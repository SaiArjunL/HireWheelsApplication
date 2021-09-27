package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.VehicleCategoryDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.entities.VehicleCategory;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.ChronoLocalDate;
import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDao vehicleDao;

    @Autowired
    VehicleCategoryDao vehicleCategoryDao;

    @Autowired
    VehicleSubcategoryDao vehicleSubcategoryDao;

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<Vehicle> getAllVehicles(){

        return vehicleDao.findAll();
    }

    public Set<Vehicle> getAvailableVehicles(String category, int locationId, ChronoLocalDate pickupDate,
                                              ChronoLocalDate dropoffDate){

        List<Vehicle> vehicles=vehicleDao.findAll();

        Set<Vehicle> availableVehicles=new HashSet<>();
        List<Vehicle> av=new ArrayList<>();

        for(Vehicle v: vehicles){

            if(v.getAvailabilityStatus()==1){

                if(v.getVehicleSubcategory().getVehicleCategory().getVehicleCategoryName().equals(category)){
                    if(v.getLocation().getLocationId()==locationId){
                        av.add(v);
                              }
                }
            }
        }
        for(Vehicle v1:av) {
            List<Booking> bookings = bookingDao.findByVehicle(v1);
            for(Booking b: bookings){
                if(b.getPickupDate().compareTo(pickupDate)<0 && b.getDropoffDate().compareTo(pickupDate)<0){
                    availableVehicles.add(v1);


                }
                else if(b.getPickupDate().compareTo(pickupDate)>0 && b.getPickupDate().compareTo(dropoffDate)>0){
                    availableVehicles.add(v1);
                }
            }

        }

        for(Vehicle vehicle: av){
            availableVehicles.add(vehicle);
        }
        return availableVehicles;


    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleDao.save(vehicle);
    }

    @Override
    public  Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleDetailsNotFoundException("Vehicle not found for id: " + id)
                );
    }

}
