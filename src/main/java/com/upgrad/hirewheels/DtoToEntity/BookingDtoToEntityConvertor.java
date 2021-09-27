package com.upgrad.hirewheels.DtoToEntity;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.LocationDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.LocationService;
import com.upgrad.hirewheels.services.UserService;
import com.upgrad.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Access;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
@Component
public class BookingDtoToEntityConvertor {
    @Autowired
    LocationService locationService;

    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;

    public Booking converter(BookingDto bookingDto) throws LocationDetailsNotFoundException, UserDetailsNotFoundException, VehicleDetailsNotFoundException {
        Booking booking=new Booking();
        booking.setBookingId(bookingDto.getBookingId());
        booking.setAmount(bookingDto.getAmount());
        booking.setLocation(locationService.getLocationDetails(bookingDto.getLocation()));
        booking.setUser(userService.getUserDetails(bookingDto.getUser()));
        booking.setVehicle(vehicleService.getVehicleDetails(bookingDto.getVehicle()));
        String p=bookingDto.getPickupDate();
        String pdate[] =p.split("-");
        LocalDate pickup= LocalDate.of(Integer.parseInt(pdate[0]),Integer.parseInt(pdate[1]),
                Integer.parseInt(pdate[2]));
        booking.setPickupDate(pickup);
        String d=bookingDto.getDropoffDate();
        String ddate[] =d.split("-");
        LocalDate dropoff= LocalDate.of(Integer.parseInt(ddate[0]),Integer.parseInt(ddate[1]),
                Integer.parseInt(ddate[2]));
        booking.setDropoffDate(dropoff);
        String b=bookingDto.getBookingDate();
        String bdate[]=b.split("-");
        LocalDate bookingDate= LocalDate.of(Integer.parseInt(ddate[0]),Integer.parseInt(ddate[1]),
                Integer.parseInt(ddate[2]));
        booking.setBookingDate(bookingDate);

        return booking;

    }
}
