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
public class CabBookingServiceApplication{
	


	public static void main(String[] args) {
		SpringApplication.run(CabBookingServiceApplication.class, args);
	}


	

}
