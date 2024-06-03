package com.lovehotel.hotelHeaven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping
    public String submitBooking(@Valid BookingModel bookingModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "booking";
        }
        bookingService.createBooking(bookingModel);
        model.addAttribute("message", "予約が完了しました。");
        return "booking";
    }
}
