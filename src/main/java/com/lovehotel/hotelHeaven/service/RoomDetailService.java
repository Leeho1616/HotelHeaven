package com.lovehotel.hotelHeaven.service;

import org.springframework.stereotype.Service;

@Service
public class RoomDetailService {
	
	public String getRoomDetail(String roomId) {
		switch(roomId) {
		case "A1": return "Description for Room A1...";
        case "A2": return "Description for Room A2...";
        case "A3": return "Description for Room A3...";
        case "A4": return "Description for Room A4...";
        case "B1": return "Description for Room B1...";
        case "B2": return "Description for Room B2...";
        case "B3": return "Description for Room B3...";
        case "B4": return "Description for Room B4...";
        case "C1": return "Description for Room C1...";      
        case "C3": return "Description for Room C3...";
        default: return "Room description not available.";
		}
	}

}
