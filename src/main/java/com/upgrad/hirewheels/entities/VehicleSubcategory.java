package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
public class VehicleSubcategory {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_subcategory_id")
    private int vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", length = 50, nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_day",precision = 10, scale = 2, nullable = false)
    private float pricePerDay;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private VehicleCategory vehicleCategory;

    @OneToMany (mappedBy = "vehicleSubcategory", fetch = FetchType.EAGER,cascade =  {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public VehicleSubcategory() {
    }

    public VehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName,
                              float pricePerDay, VehicleCategory vehicleCategory) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;

    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{vehicleSubcategoryId="+vehicleSubcategoryId
                +", vehicleSubcategoryName="+vehicleSubcategoryName
                +", pricePerDay="+pricePerDay
                +", vehicleCategory="+vehicleCategory
                +"}";
    }
}
