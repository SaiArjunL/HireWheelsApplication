package com.upgrad.hirewheels.DtoToEntity;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingEntityToDtoConvertor {

    public BookingDto Convertor(Booking booking){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setAmount(booking.getAmount());
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setLocation(booking.getLocation().getLocationId());
        bookingDto.setUser(booking.getUser().getUserId());
        bookingDto.setVehicle(booking.getVehicle().getVehicleId());
        bookingDto.setPickupDate(booking.getPickupDate().toString());
        bookingDto.setDropoffDate(booking.getDropoffDate().toString());
        bookingDto.setBookingDate(booking.getBookingDate().toString());
        return  bookingDto;
    }
}
