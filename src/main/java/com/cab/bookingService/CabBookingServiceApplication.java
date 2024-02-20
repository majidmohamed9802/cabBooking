package com.cab.bookingService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Entity.CabBooking;
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
		//findByNumber();
		//cancelBooking();
	}
	
	
	public void bookCab() {
		try {
			CabBookingDTO dto = new CabBookingDTO();
			dto.setSource("Los Angles");
			dto.setDestination("San Diego");
			dto.setUserMobile(99999L);
		
			String message =cabService.bookCab(dto);
			
			LOGGER.info(message);
			
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	
	public void findByNumber() {
		
		try {
			Long number = 9877766756l;
			CabBookingDTO dto= cabService.findBookingByNumber(number);
			LOGGER.info(dto + "-------------------- SUCCESSFUL");
						
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		
	}
	
	public void cancelBooking() {
		try {
			
			Integer bookingId = 7;
			String message = cabService.cancelBooking(bookingId);
			LOGGER.info(message);
			
		}catch(Exception e ) {
			LOGGER.info(e.getMessage());
		}
	}

}
