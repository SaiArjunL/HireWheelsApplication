package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
    public Vehicle addVehicle(Vehicle vehicle);
    public Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException;
}
