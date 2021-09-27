package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {

    @Id
    @GeneratedValue
    @Column(name = "fuel_type_id")
    private int fuelTypeId;

    @Column(name = "fuel_type", length = 50, unique = true, nullable = false)
    private String fuelType;

    @OneToMany (mappedBy = "fuelType", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public FuelType() {
    }

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;

    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "FuelType{fuelTypeId="+fuelTypeId
                +", fuelType"+fuelType
                +"}";
    }
}
