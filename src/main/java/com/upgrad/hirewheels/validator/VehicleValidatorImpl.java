package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.FuelTypeDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;
import com.upgrad.hirewheels.services.FuelTypeServiceImpl;
import com.upgrad.hirewheels.services.LocationServiceImpl;
import com.upgrad.hirewheels.services.VehicleSubcategoryService;
import com.upgrad.hirewheels.services.VehicleSubcategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleValidatorImpl {

    @Autowired
    FuelTypeServiceImpl fuelTypeService;

    @Autowired
    LocationServiceImpl locationService;

    @Autowired
    VehicleSubcategoryServiceImpl vehicleSubcategoryService;


    public void validateVehicle(VehicleDto vehicleDto) throws APIException, FuelTypeDetailsNotFoundException, LocationDetailsNotFoundException, VehicleSubcategoryDetailsNotFoundException {

       if(vehicleDto.getVehicleImageUrl()==null || vehicleDto.getVehicleImageUrl().length()<=0){
           throw  new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getAvailabilityStatus()!=0 || vehicleDto.getAvailabilityStatus()!=1){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getColor()==null || vehicleDto.getColor().length()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getVehicleModel()==null || vehicleDto.getVehicleModel().length()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getVehicleNumber()==null || vehicleDto.getVehicleNumber().length()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getFuelTypeId()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getLocationId()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(vehicleDto.getVehicleSubcategoryId()<=0){
           throw new APIException("Fields shouldn’t be null or empty");
       }
       if(fuelTypeService.getFuelTypeDetails(vehicleDto.getLocationId()).getFuelType()==null)
           throw new APIException("Fields shouldn’t be null or empty");
       if(locationService.getLocationDetails(vehicleDto.getLocationId())==null)
           throw new APIException("Invalid Location Id for vehicle");
       if(locationService.getLocationDetails(vehicleDto.getLocationId()).getLocationName()==null)
           throw new APIException("Fields shouldn’t be null or empty");
       if(vehicleSubcategoryService.getVehicleSubcategoryDetails(vehicleDto.getVehicleSubcategoryId()).getVehicleSubcategoryName()==null)
            throw new APIException("Fields shouldn’t be null or empty");


    }
}
