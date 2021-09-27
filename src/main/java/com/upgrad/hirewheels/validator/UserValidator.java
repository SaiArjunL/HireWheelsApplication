package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.SignUpDto;

import com.upgrad.hirewheels.dto.UserLoginDto;
import com.upgrad.hirewheels.exceptions.APIException;

public interface UserValidator {

    public void validateUser(SignUpDto userDto) throws APIException;
    public void validateLogin(UserLoginDto loginDto) throws APIException;
}
