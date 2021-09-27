package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.StatusDto;
import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.responses.CustomResponses;
import com.upgrad.hirewheels.services.UserService;
import com.upgrad.hirewheels.services.VehicleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class AdminController {

    @Autowired
    VehicleServiceImpl vehicleService;

    @Autowired
    ModelMapper modelmapper;


    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(value="/vehicles",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDto vehicleDto,@RequestHeader(value = "ACCESS-TOKEN") String token) throws APIException, UserDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");
        if(!userService.getUserByEmailId(token).getRole().getRoleName().equalsIgnoreCase("Admin"))
            throw new APIException("This feature is only available to admin");
        Vehicle newVehicle = modelmapper.map(vehicleDto, Vehicle.class);
        Vehicle savedVehicle = vehicleService.addVehicle(newVehicle);
        VehicleDto savedVehicleDto = modelmapper.map(savedVehicle, VehicleDto.class);
        logger.debug("Vehicle Added Successfully",savedVehicle);
        CustomResponses response= new CustomResponses("Vehicle Added Successfully",HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping(value ="/vehicles/{id}",consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeVehicleAvailability(@PathVariable ("id") int id,
                                                              @RequestBody StatusDto statusDto,@RequestHeader(value = "ACCESS-TOKEN") String token) throws VehicleDetailsNotFoundException, APIException, UserDetailsNotFoundException {
        if(token == null)
            throw new APIException("Please add proper authentication");
        if(!userService.getUserByEmailId(token).getRole().getRoleName().equalsIgnoreCase("Admin"))
            throw new APIException("This feature is only available to admin");


        if(statusDto.getAvailabilityStatus()!=0 ){
            if(statusDto.getAvailabilityStatus()!=1) {
                CustomResponses response = new CustomResponses("Invalid status value", HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }

        Vehicle vehicle= vehicleService.getVehicleDetails(id);
        vehicle.setAvailabilityStatus(statusDto.getAvailabilityStatus());
        vehicleService.addVehicle(vehicle);
        logger.debug("Update vehicle availability details : vehicle id :" + id, vehicle);
        CustomResponses response = new CustomResponses("Activity Performed Successfully", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    }