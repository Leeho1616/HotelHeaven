package com.lovehotel.hotelHeaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
	
	@GetMapping("/rooms")
	public String rooms() {
		return "rooms";
	}
	
	
	
}
