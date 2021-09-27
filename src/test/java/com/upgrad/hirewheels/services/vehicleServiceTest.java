package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.dao.VehicleSubcategoryDao;
import com.upgrad.hirewheels.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class vehicleServiceTest {
    @Mock
    VehicleDao vehicleDao;

    @Mock
    VehicleSubcategoryDao vehicleSubcategoryDao;

    @Mock
    LocationDao locationDao;

    @Mock
    BookingDao bookingDao;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @BeforeEach
    public void setupMockito(){
        List<Vehicle> v=new ArrayList<>();
        Vehicle v1=new Vehicle(1,"save test","save test",
                "save test",1,"save test",new FuelType(),new Location(1,"save test",
                "save test", "save test",new City()),
                new VehicleSubcategory(1,"save test",300,
                        new VehicleCategory(1,"save test")));
        Vehicle v2= new Vehicle(2,"save test","save test",
                "save test",1,"save test",new FuelType(),new Location(1,"save test",
                "save test", "save test",new City()),
                new VehicleSubcategory(1,"save test",300,
                        new VehicleCategory(1,"save test")));
        v.add(v1);
        v.add(v2);
        Mockito.when(vehicleDao.findAll()).thenReturn(v);

        List<Booking> bv1=new ArrayList<>();
        Booking b1=new Booking(1,LocalDate.of(2020,02,02),
                LocalDate.of(2020,02,04),
                LocalDate.of(2020,02,01),300,new Location(),v1,
                new Users());
        Booking b2=new Booking(2,LocalDate.of(2020,03,02),
                LocalDate.of(2020,03,04),
                LocalDate.of(2020,02,01),300,new Location(),v1,
                new Users());
        Booking b3=new Booking(3,LocalDate.of(2020,04,02),
                LocalDate.of(2020,04,04),
                LocalDate.of(2020,02,01),300,new Location(),v2,
                new Users());
        bv1.add(b1);
        bv1.add(b2);
        List<Booking> bv2=new ArrayList<>();
        bv2.add(b3);
        Mockito.when(bookingDao.findByVehicle(v1)).thenReturn(bv1);
        Mockito.when(bookingDao.findByVehicle(v2)).thenReturn(bv2);
    }

    @Test
    public void testGetAllVehicles(){
      List<Vehicle> vehicles= vehicleService.getAllVehicles();
        Assertions.assertEquals(1,vehicles.get(0).getVehicleId());
        Assertions.assertEquals(2,vehicles.get(1).getVehicleId());
    }

    @Test
    public void testGetAvailableVehicles(){
        String category="save test";
         int locationId=1;
        ChronoLocalDate pickupDate=LocalDate.of(2020,03,05);
        ChronoLocalDate dropoffDate=LocalDate.of(2020,03,07);

        Set<Vehicle> vehicles= vehicleService.getAvailableVehicles(category,locationId,pickupDate,dropoffDate);
        Assertions.assertEquals(2,vehicles.size());
    }
}
