package com.upgrad.hirewheels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;

@Service
public class initServiceImpl implements initService {

    @Autowired
    RoleDao userRoleDao;

    @Autowired
    UsersDao userDao;

    @Autowired
    VehicleCategoryDao vehicleCategoryDao;

    @Autowired
    VehicleSubcategoryDao vehicleSubCategoryDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    FuelTypeDao fuelTypeDao;

    @Autowired
    LocationDao locationDao;

    public void start() {
        addUserRole();
        addUsers();
        addVehicleCategory();
        addCity();
        addFuelType();
        addLocation();
        addVehicleSubCategory();
    }

    private void addCity() {
        City c=new City();
        c.setCityId(1);
        c.setCityName("Mumbai");
        cityDao.save(c);
    }

    private void addLocation() {
        Location location1 = new Location();
        location1.setCity(cityDao.findById(6));
        location1.setLocationId(1);
        location1.setLocationName("Worli");
        location1.setLocationAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location1.setPincode("400018");


        locationDao.save(location1);

        Location location2 = new Location();
        location2.setCity(cityDao.findById(6));
        location2.setLocationId(2);
        location2.setLocationName("Chembur");
        location2.setLocationAddress("Optic Complex");
        location2.setPincode("400019");

        locationDao.save(location2);

        Location location3 = new Location();
        location3.setCity(cityDao.findById(6));
        location3.setLocationId(3);
        location3.setLocationName("Powai");
        location3.setLocationAddress("Hiranandani Tower");
        location3.setPincode("400017");

        locationDao.save(location3);
    }

        private void addFuelType() {

            FuelType f1=new FuelType();
            f1.setFuelType("Patrol");
            fuelTypeDao.save(f1);

            FuelType f2=new FuelType();
            f2.setFuelType("Diesel");
            fuelTypeDao.save(f2);
        }

    private void addVehicleCategory() {

        VehicleCategory vc1=new VehicleCategory();
        vc1.setVehicleCategoryId(10);
        vc1.setVehicleCategoryName("CAR");
        vehicleCategoryDao.save(vc1);

        VehicleCategory vc2=new VehicleCategory();
        vc2.setVehicleCategoryId(11);
        vc2.setVehicleCategoryName("BIKE");
        vehicleCategoryDao.save(vc2);
    }

    private void addVehicleSubCategory() {


        VehicleSubcategory vs1=new VehicleSubcategory();
        vs1.setVehicleCategory(vehicleCategoryDao.findById(4).get());
        vs1.setVehicleSubcategoryId(111);
        vs1.setVehicleSubcategoryName("SUV");
        vs1.setPricePerDay(300);

        vehicleSubCategoryDao.save(vs1);

        VehicleSubcategory vs2=new VehicleSubcategory();
        vs2.setVehicleCategory(vehicleCategoryDao.findById(4).get());
        vs2.setVehicleSubcategoryId(112);
        vs2.setVehicleSubcategoryName("SEDAN");
        vs2.setPricePerDay(350);

        vehicleSubCategoryDao.save(vs2);

        VehicleSubcategory vs3=new VehicleSubcategory();
        vs3.setVehicleCategory(vehicleCategoryDao.findById(4).get());
        vs3.setVehicleSubcategoryId(113);
        vs3.setVehicleSubcategoryName("HATCHBACK");
        vs3.setPricePerDay(250);

        vehicleSubCategoryDao.save(vs3);

        VehicleSubcategory vs4=new VehicleSubcategory();
        vs4.setVehicleCategory(vehicleCategoryDao.findById(5).get());
        vs4.setVehicleSubcategoryId(114);
        vs4.setVehicleSubcategoryName("CRUISER");
        vs4.setPricePerDay(200);

        vehicleSubCategoryDao.save(vs4);

        VehicleSubcategory vs5=new VehicleSubcategory();
        vs5.setVehicleCategory(vehicleCategoryDao.findById(5).get());
        vs5.setVehicleSubcategoryId(115);
        vs5.setVehicleSubcategoryName("DIRT BIKE");
        vs5.setPricePerDay(200);

        vehicleSubCategoryDao.save(vs5);

        VehicleSubcategory vs6=new VehicleSubcategory();
        vs6.setVehicleCategory(vehicleCategoryDao.findById(5).get());
        vs6.setVehicleSubcategoryId(116);
        vs6.setVehicleSubcategoryName("SPORTS BIKE");
        vs6.setPricePerDay(150);

        vehicleSubCategoryDao.save(vs6);

    }

    private void addUserRole() {

        Role r1=new Role();
        r1.setRoleName("Admin");
        userRoleDao.save(r1);

        Role r2=new Role();
        r2.setRoleName("User");
        userRoleDao.save(r2);


    }

    private void addUsers() {

        Users u=new Users();
        u.setRole(userRoleDao.findById(1));
        u.setWalletMoney(10000);
        u.setPassword("admin@123");
        u.setMobileNumber("9876543212");
        u.setEmailId("admin@gmail.com");
        u.setFirstName("RUTU");
        u.setLastName("Admin");
        userDao.save(u);

    }

}
