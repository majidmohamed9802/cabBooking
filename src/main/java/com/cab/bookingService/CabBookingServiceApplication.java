package com.cab.bookingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Service.CabBookingServiceImpl;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class CabBookingServiceApplication implements CommandLineRunner{
	
	public final static Log LOGGER = LogFactory.getLog(CabBookingServiceApplication.class);
	
	@Autowired
	CabBookingServiceImpl cabService ;

	public static void main(String[] args) {
		SpringApplication.run(CabBookingServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookCab();
	}
	
	
	public void bookCab() {
		try {
			CabBookingDTO dto = new CabBookingDTO();
			dto.setSource("San Jose");
			dto.setDestination("Los Angles");
			dto.setUserMobile(9998766756L);
		
			String message =cabService.bookCab(dto);
			
			LOGGER.info(message);
			
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
	}

}
