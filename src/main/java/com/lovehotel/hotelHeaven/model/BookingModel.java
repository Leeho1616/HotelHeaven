package com.lovehotel.hotelHeaven.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingModel {
    private Long id;

    @NotEmpty(message = "Room type is required")
    private String roomType;

    @NotEmpty(message = "Stay type is required")
    private String stayType;

    @NotNull(message = "Check-in date is required")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate checkInDate;

    @NotNull(message = "Check-in time is required")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime checkInTime;

    @Min(value = 1, message = "Number of adults must be at least 1")
    private int numAdults;

    @Min(value = 0, message = "Number of children cannot be negative")
    private int numChildren;

    @NotEmpty(message = "Full name is required")
    private String fullName;

    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String requests;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }
}
