package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private  int cityId;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    @OneToMany (mappedBy = "city", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Location> locations;

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{cityId="+cityId
                +", cityName"+cityName
                +"}";
    }
}
