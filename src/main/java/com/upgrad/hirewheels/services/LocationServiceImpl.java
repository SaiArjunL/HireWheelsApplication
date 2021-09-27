package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.entities.FuelType;
import com.upgrad.hirewheels.entities.Location;
import com.upgrad.hirewheels.exceptions.FuelTypeDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{


    @Autowired
    LocationDao locationDao;

    @Override
    public Location getLocationDetails(int id) throws LocationDetailsNotFoundException {
        return locationDao.findById(id)
                .orElseThrow(
                        () -> new LocationDetailsNotFoundException("Location Id Invalid for Vehicle: " + id)
                );
    }
}
