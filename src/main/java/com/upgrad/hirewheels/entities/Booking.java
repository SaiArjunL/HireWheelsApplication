package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import  java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "dropoff_date", nullable = false)
    private LocalDate dropoffDate;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(precision = 10, scale = 2, nullable = false)
    private float amount;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Booking() {
    }

    public Booking(int bookingId, LocalDate pickupDate, LocalDate dropoffDate, LocalDate bookingDate,
                   float amount, Location location, Vehicle vehicle, Users user) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId="+bookingId+
                ", pickupDate="+pickupDate
                +", dropoffDate="+dropoffDate
                +", bookingDate="+bookingDate
                +", amount="+amount
                +", location="+location
                +", vehicle="+vehicle
                +", user="+user
                +"}";
    }
}
