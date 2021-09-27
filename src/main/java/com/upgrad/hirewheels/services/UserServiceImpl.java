package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    RoleDao roleDao;

    @Autowired
    UsersDao usersDao;

    @Override
    public Users getUserDetails(int id) throws UserDetailsNotFoundException {
        return usersDao.findById(id)
                .orElseThrow(
                        () -> new UserDetailsNotFoundException("User not found for id: " + id)
                );
    }
    @Override
    public Users createUser(Users user) throws UserAlreadyExitsException{
        System.out.println(user);
        if (usersDao.findByEmailId(user.getEmailId())!=null) {
            throw new UserAlreadyExitsException("Email Already Exists");
        }
        if (usersDao.findByMobileNumber(user.getMobileNumber())!=null) {
            throw new UserAlreadyExitsException("Mobile Number Already Exists");
        }

        System.out.println(user);
        return usersDao.save(user);


    }

    @Override
    public Users getUser(String emailId, String password) throws UserAlreadyExitsException{
        if(usersDao.findByEmailId(emailId)!=null){
            if(usersDao.findByEmailId(emailId).getPassword().equals(password)){
                return usersDao.findByEmailId(emailId);
            }else {
                throw new UserAlreadyExitsException("Unauthorized User");
            }
        }else {
            throw new UserAlreadyExitsException("User not Registered");
        }

    }

    @Override
    public Users getUserByEmailId(String emailId ) throws UserDetailsNotFoundException {

        Users user= usersDao.findByEmailId(emailId);
        if(user==null)
            throw new UserDetailsNotFoundException("Invalid Token?EmailId");
        return user;

    }

    @Override
    public Users getUserByMobileNumber(String mobileNumber){
        return usersDao.findByMobileNumber(mobileNumber);
    }

}
