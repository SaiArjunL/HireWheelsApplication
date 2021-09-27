package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.VehicleSubcategory;
import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;

public interface VehicleSubcategoryService {

    public VehicleSubcategory getVehicleSubcategoryDetails(int id) throws VehicleSubcategoryDetailsNotFoundException;
    }
