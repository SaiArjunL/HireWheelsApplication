package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class userServiceTest {
    @Mock
    UsersDao usersDao;

    @Mock
    RoleDao roleDao;


    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    public void setUpMockito(){

        Role role=new Role(1,"save test");

        Users u1=new Users(1,"save test","save test","save test",
                "save test1","save test1",10, role);
        Users u2=new Users(2,"save test","save test","save test",
                "save test2","save test2",10,
                role);

        Users user=u1;
        Mockito.when(usersDao.save(user)).thenReturn(u1);
        Mockito.when(usersDao.save(u1)).thenReturn(u1);
        Mockito.when(usersDao.findById(1)).thenReturn(Optional.of(u1));

        Mockito.when(usersDao.findByMobileNumber("save test1")).thenReturn(u1);

        Mockito.when(usersDao.findByEmailId("save test1")).thenReturn(u1);

    }

    @Test
    public void testCreateUser() throws UserAlreadyExitsException {
        Role role=new Role();
        role.setRoleName("save test");
        Users u1= new Users();
        u1.setFirstName("save test");
        u1.setWalletMoney(10);
        u1.setPassword("save test");
        u1.setRole(role);
        u1.setMobileNumber("save test");
        u1.setEmailId("save test");
        u1.setLastName("save test");

        Users savedUser= userService.createUser(u1);
        System.out.println(savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("save test", savedUser.getFirstName());
        Assertions.assertEquals("save test", savedUser.getLastName());
        Assertions.assertEquals("save test1", savedUser.getPassword());
        Assertions.assertEquals("save test1", savedUser.getEmailId());
        Assertions.assertEquals("save test1", savedUser.getMobileNumber());
        Assertions.assertEquals(10, savedUser.getWalletMoney());
        Assertions.assertEquals("save test", savedUser.getRole().getRoleName());

    }
    @Test
    public void testGetUser() throws UserAlreadyExitsException {
        Users getUser= userService.getUser("save test1", "save test");

        Assertions.assertNotNull(getUser);
        Assertions.assertTrue(getUser.getUserId() != 0);
        Assertions.assertEquals("save test", getUser.getFirstName());
        Assertions.assertEquals("save test", getUser.getLastName());
        Assertions.assertEquals("save test", getUser.getPassword());
        Assertions.assertEquals("save test1", getUser.getEmailId());
        Assertions.assertEquals("save test1", getUser.getMobileNumber());
        Assertions.assertEquals(10, getUser.getWalletMoney());
        Assertions.assertEquals("save test", getUser.getRole().getRoleName());

    }


}
