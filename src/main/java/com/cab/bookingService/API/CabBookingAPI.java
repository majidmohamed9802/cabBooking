package com.cab.bookingService.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Exception.CabException;
import com.cab.bookingService.Service.CabBookingService;

@RestController
@RequestMapping(value = "/bookings")
public class CabBookingAPI {
	
	@Autowired
	CabBookingService service;
	
	@GetMapping(value = "/{mobileNo}")
	public ResponseEntity<CabBookingDTO> findBooking(@PathVariable Long mobileNo) throws CabException{
		
		CabBookingDTO dto = service.findBookingByNumber(mobileNo);
			
		return new ResponseEntity<CabBookingDTO>(dto,HttpStatus.OK);
		
	}
	
	//http://localhost:8080/bookings/99999


}
