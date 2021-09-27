package com.upgrad.hirewheels.DtoToEntity;

import com.upgrad.hirewheels.dto.SignUpDto;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupDtoToEntity {


    @Autowired
    RoleService roleService;

    public Users convertor(SignUpDto signUpDto){
        Users user=new Users();
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setEmailId(signUpDto.getEmailId());
        user.setMobileNumber(signUpDto.getMobileNumber());
        user.setWalletMoney(1000);
        user.setRole(roleService.findByRoleName("User"));
        user.setPassword(signUpDto.getPassword());
        return user;
    }
}
