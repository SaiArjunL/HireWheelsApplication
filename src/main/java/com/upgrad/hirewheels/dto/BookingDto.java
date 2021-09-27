package com.upgrad.hirewheels.dto;



public class BookingDto {
    private int bookingId;

    private String pickupDate;

    private String dropoffDate;

    private String bookingDate;

    private float amount;


    private int locationId;


    private int vehicleId;

    private int userId;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getLocation() {
        return locationId;
    }

    public void setLocation(int location) {
        this.locationId = location;
    }

    public int getVehicle() {
        return vehicleId;
    }

    public void setVehicle(int vehicle) {
        this.vehicleId = vehicle;
    }

    public int getUser() {
        return this.userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }
}
