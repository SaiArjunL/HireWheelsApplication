package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.VehicleServiceImpl;
import org.hibernate.annotations.NamedNativeQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class VehicleController {

        @Autowired
        VehicleServiceImpl vehicleService;

        @Autowired
        ModelMapper modelmapper;

        @GetMapping(value = "/getV",produces= MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getVehicles(@RequestParam("categoryName") String categoryName,
                                          @RequestParam("pickupDate") String pickupDate,
                                          @RequestParam("dropoffDate") String dropoffDate,
                                          @RequestParam("locationId") int locationId)
                throws VehicleDetailsNotFoundException, APIException {


                if (categoryName == null || pickupDate == null || dropoffDate == null || locationId <= 0) {
                        List<Vehicle> vehicles = vehicleService.getAllVehicles();
                        List<VehicleDto> vehicleDtos = new ArrayList<>();
                        for (Vehicle vehicle : vehicles) {
                                vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                        }

                        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
                }
                String pdate[] =pickupDate.split("-");
                String ddate[] =dropoffDate.split("-");

                ChronoLocalDate pickup= LocalDate.of(Integer.parseInt(pdate[0]),Integer.parseInt(pdate[1]),
                        Integer.parseInt(pdate[2]));

                ChronoLocalDate dropoff= LocalDate.of(Integer.parseInt(ddate[0]),Integer.parseInt(ddate[1]),
                        Integer.parseInt(ddate[2]));

                if(pickup.compareTo(dropoff)>0)
                        throw new APIException("Drop-off date should be greater than today's date and greater than the pickup date");

                if(pickup.compareTo(LocalDate.now())<0)
                        throw new APIException("Pickup date should not be less than today's date.");

                Set<Vehicle> vehicles = vehicleService.getAvailableVehicles(categoryName, locationId,
                        pickup, dropoff);
                List<VehicleDto> vehicleDtos = new ArrayList<>();
                for (Vehicle vehicle : vehicles) {
                        vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                }

                return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);


        }
}
