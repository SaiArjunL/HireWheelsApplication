package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.VehicleCategory;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleSubcategoryDao extends JpaRepository<VehicleSubcategory, Integer> {

    //VehicleSubcategory findById(int id);
    List<VehicleSubcategory> findByVehicleCategory(VehicleCategory vehicleCategory);
}
