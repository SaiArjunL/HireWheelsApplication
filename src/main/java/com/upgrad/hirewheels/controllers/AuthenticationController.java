package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.DtoToEntity.SignupDtoToEntity;
import com.upgrad.hirewheels.dto.SignUpDto;
import com.upgrad.hirewheels.dto.UserDto;
import com.upgrad.hirewheels.dto.UserLoginDto;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.responses.CustomResponses;
import com.upgrad.hirewheels.services.UserService;
import com.upgrad.hirewheels.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class AuthenticationController {

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;

    @Autowired
    SignupDtoToEntity signupDtoToEntity;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/signup",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signUp(@RequestBody SignUpDto userDto) throws APIException, UserAlreadyExitsException, UserDetailsNotFoundException {
         userValidator.validateUser(userDto);
         if(userService.getUserByEmailId(userDto.getEmailId())!=null ||
                 userService.getUserByMobileNumber(userDto.getMobileNumber())!=null){
             throw new APIException(" Email already exists");
         }

        Users user=signupDtoToEntity.convertor(userDto);
         userService.createUser(user);
         CustomResponses response =  new CustomResponses("User Successfully Signed Up",
                HttpStatus.CREATED.value());
         return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserLoginDto loginDTO)
            throws APIException, UserAlreadyExitsException {

        userValidator.validateLogin(loginDTO);
        String userName=loginDTO.getEmailId();
        Users user=userService.getUser(loginDTO.getEmailId(),loginDTO.getPassword());
        UserDto userDto= modelMapper.map(user,UserDto.class);
        Map<String, String> model = new HashMap<>();
        model.put("message","Logged in Successfully");
        model.put("token",userName);
        return new ResponseEntity<>(model,HttpStatus.OK);

    }
}
