package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;

public interface BookingService {
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public Booking addBooking(Booking booking)throws Exception, BookingDetailsNotFoundException, UserDetailsNotFoundException;
    }
