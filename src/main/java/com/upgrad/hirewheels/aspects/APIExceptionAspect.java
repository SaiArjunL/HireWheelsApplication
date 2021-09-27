package com.upgrad.hirewheels.aspects;

import com.upgrad.hirewheels.exceptions.*;
import com.upgrad.hirewheels.responses.CustomResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionAspect {
    @ExceptionHandler({APIException.class, BookingDetailsNotFoundException.class, FuelTypeDetailsNotFoundException.class,
            LocationDetailsNotFoundException.class, UserAlreadyExitsException.class, UserDetailsNotFoundException.class,
            VehicleDetailsNotFoundException.class, VehicleSubcategoryDetailsNotFoundException.class})
    public ResponseEntity<CustomResponses> handleAPIException(Exception e){
        CustomResponses response = new CustomResponses(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}