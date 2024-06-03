package com.lovehotel.hotelHeaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovehotel.hotelHeaven.mapper.BookingMapper;
import com.lovehotel.hotelHeaven.model.BookingModel;

@Service
public class BookingService {

    @Autowired
    private BookingMapper bookingMapper;

    public void createBooking(BookingModel bookingModel) {
        bookingMapper.insertBooking(bookingModel);
    }
}
