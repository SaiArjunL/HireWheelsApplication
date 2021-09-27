package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.FuelType;
import com.upgrad.hirewheels.exceptions.FuelTypeDetailsNotFoundException;

public interface FuelTypeService {
    public FuelType getFuelTypeDetails(int id) throws FuelTypeDetailsNotFoundException;
}
