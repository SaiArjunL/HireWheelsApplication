package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

public interface AdminService {
    public Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException;
    public Vehicle registerVehicle(Vehicle vehicle);
    public Vehicle changeAvailability(Vehicle vehicle, int status) throws VehicleDetailsNotFoundException;
}
