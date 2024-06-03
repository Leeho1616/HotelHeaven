package com.lovehotel.hotelHeaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lovehotel.hotelHeaven.mapper")
public class HotelHeavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelHeavenApplication.class, args);
	}

}
