package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.FuelTypeDao;
import com.upgrad.hirewheels.entities.FuelType;
import com.upgrad.hirewheels.exceptions.FuelTypeDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {
    @Autowired
    FuelTypeDao fuelTypeDao;

    @Override
    public FuelType getFuelTypeDetails(int id) throws FuelTypeDetailsNotFoundException {
        return fuelTypeDao.findById(id)
                .orElseThrow(
                        () -> new FuelTypeDetailsNotFoundException("FuelType not found for id: " + id)
                );
    }
}
