package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
     //Vehicle findById(int id);
     List<Vehicle> findAll();
     List<Vehicle> findByVehicleSubcategory(VehicleSubcategory vehicleSubcategory);
}
