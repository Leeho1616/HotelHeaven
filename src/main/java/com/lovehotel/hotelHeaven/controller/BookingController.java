package com.lovehotel.hotelHeaven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovehotel.hotelHeaven.model.BookingModel;
import com.lovehotel.hotelHeaven.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String bookingForm(Model model) {
        model.addAttribute("bookingModel", new BookingModel());
        return "booking";
    }

    @PostMapping("/confirm")
    public String confirmBooking(@Valid BookingModel bookingModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "booking";
        }
        model.addAttribute("bookingModel", bookingModel);
        return "confirmBooking";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String submitBooking(@Valid @RequestBody BookingModel bookingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "There was an error with your submission.";
        }
        bookingService.createBooking(bookingModel);
        return "予約が成功しました。";
    }
}
