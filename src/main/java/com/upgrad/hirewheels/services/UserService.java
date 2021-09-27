package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;

public interface UserService {
    Users createUser(Users users) throws UserAlreadyExitsException;
    public Users getUserDetails(int id) throws UserDetailsNotFoundException;
    public Users getUser(String emailId, String password) throws UserAlreadyExitsException;
    public Users getUserByEmailId(String emailId) throws UserDetailsNotFoundException;
    public Users getUserByMobileNumber(String mobileNumber);
    }
