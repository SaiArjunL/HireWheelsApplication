package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.SignUpDto;

import com.upgrad.hirewheels.dto.UserLoginDto;
import com.upgrad.hirewheels.exceptions.APIException;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator{

    @Override
    public void validateUser(SignUpDto userDto) throws APIException {
        if(userDto.getFirstName()==null || userDto.getFirstName().length()<=0){
            throw new APIException("FirstName cannot be null or empty");
        }
        if(userDto.getPassword()==null || userDto.getPassword().length()<5)
            throw new APIException("Password cannot be null or less than 5 characters");
        if(userDto.getMobileNumber()==null || userDto.getMobileNumber().length()!=10)
            throw  new APIException("Mobile Number cannot be null or empty and must be 10 digits");
        if(userDto.getEmailId()==null || userDto.getEmailId().length()<=0)
            throw new APIException("EmailId cannot be null or empty");

    }
    @Override
    public void validateLogin(UserLoginDto loginDto) throws APIException {
        if(loginDto.getPassword()==null || loginDto.getPassword().length()<5)
            throw new APIException("Password cannot be null or less than 5 characters");

        if(loginDto.getEmailId()==null || loginDto.getEmailId().length()<=0)
            throw new APIException("EmailId cannot be null or empty");

    }
}
