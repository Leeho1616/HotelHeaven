package com.lovehotel.hotelHeaven.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.lovehotel.hotelHeaven.model.BookingModel;

@Mapper
public interface BookingMapper {

    @Insert("INSERT INTO bookings(room_type, stay_type, check_in_date, check_in_time, num_adults, num_children, full_name, phone_number, email, requests) " +
            "VALUES (#{roomType}, #{stayType}, #{checkInDate}, #{checkInTime}, #{numAdults}, #{numChildren}, #{fullName}, #{phoneNumber}, #{email}, #{requests})")
    void insertBooking(BookingModel bookingModel);
}
