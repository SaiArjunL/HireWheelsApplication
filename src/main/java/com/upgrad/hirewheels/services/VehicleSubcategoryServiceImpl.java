package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.Location;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleSubcategoryServiceImpl implements VehicleSubcategoryService{

    @Autowired
    VehicleSubcategoryDao vehicleSubcategoryDao;

    @Override
    public VehicleSubcategory getVehicleSubcategoryDetails(int id) throws VehicleSubcategoryDetailsNotFoundException {
        return vehicleSubcategoryDao.findById(id)
                .orElseThrow(
                        () -> new VehicleSubcategoryDetailsNotFoundException("VehicleSubcategory not found for id: " + id)
                );
    }
}
