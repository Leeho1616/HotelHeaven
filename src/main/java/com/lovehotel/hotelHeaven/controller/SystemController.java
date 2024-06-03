package com.lovehotel.hotelHeaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

    @GetMapping("/pricing")
    public String pricing() {
        return "system";
    }
}
