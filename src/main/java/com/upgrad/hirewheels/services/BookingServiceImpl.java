package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDao bookingDao;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UsersDao userDao;



    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id)
                .orElseThrow(
                        () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
                );
    }


    @Override
    public Booking addBooking(Booking booking)throws Exception, BookingDetailsNotFoundException, UserDetailsNotFoundException {
        Users user=userService.getUserDetails((booking.getUser().getUserId()));

                  if(user.getWalletMoney()-booking.getAmount()>0){
                      user.setWalletMoney(user.getWalletMoney()-booking.getAmount());
                      userDao.save(user);
                      return bookingDao.save(booking);
                  }
                  throw new Exception("Insufficient Balance. Please Check With Admin");
    }
}
