package com.lovehotel.hotelHeaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lovehotel.hotelHeaven.service.RoomDetailService;

@Controller
public class RoomDetailController {
	
	@Autowired
	private RoomDetailService roomDetailService;
	
	@GetMapping("/roomDetail")
    public String roomDetail(@RequestParam("id") String roomId, Model model) {
        String roomDescription = roomDetailService.getRoomDetail(roomId);
        String roomType = roomId.substring(0, 1);
        model.addAttribute("roomId", roomId);
        model.addAttribute("roomDescription", roomDescription);
        model.addAttribute("roomType", roomType);
        return "roomDetail";
    }
}
