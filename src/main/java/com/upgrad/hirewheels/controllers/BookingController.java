package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.DtoToEntity.BookingDtoToEntityConvertor;
import com.upgrad.hirewheels.DtoToEntity.BookingEntityToDtoConvertor;
import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.services.BookingService;
import com.upgrad.hirewheels.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;



    @Autowired
    BookingDtoToEntityConvertor dToEConvertor;
    @Autowired
    BookingEntityToDtoConvertor eToDConvertor;

    @PostMapping(value="/bookings",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooking(@RequestBody BookingDto bookingDto) throws Exception {
        if((userService.getUserDetails(bookingDto.getUser())).getWalletMoney()<bookingDto.getAmount())
            throw new APIException("Insufficient balance. Please check with Admin");
        String d[]=bookingDto.getBookingDate().split("-");
        LocalDate bookingDate= LocalDate.of(Integer.parseInt(d[0]),Integer.parseInt(d[1]),
                Integer.parseInt(d[2]));
        if(bookingDate!= LocalDate.now())
            throw new APIException("Booking date should be today's date");
        Booking newBooking = dToEConvertor.converter(bookingDto);
        Booking savedBooking = bookingService.addBooking(newBooking);
        BookingDto savedBookingDTO = eToDConvertor.Convertor(savedBooking);
        return new ResponseEntity<>(savedBookingDTO, HttpStatus.CREATED);
    }

}
