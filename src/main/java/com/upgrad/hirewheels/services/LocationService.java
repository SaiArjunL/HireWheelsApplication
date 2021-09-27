package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.FuelType;
import com.upgrad.hirewheels.entities.Location;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;

public interface LocationService {

    public Location getLocationDetails(int id) throws LocationDetailsNotFoundException;
}
