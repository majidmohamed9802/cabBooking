package com.cab.bookingService.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Exception.CabException;
import com.cab.bookingService.Service.CabBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/bookings")
@Validated
public class CabBookingAPI {
	
	@Autowired
	CabBookingService service;
	
	@GetMapping(value = "/{mobileNo}")
	public ResponseEntity<CabBookingDTO> findBooking(@PathVariable Long mobileNo) throws CabException{
		
		CabBookingDTO dto = service.findBookingByNumber(mobileNo);
			
		return new ResponseEntity<CabBookingDTO>(dto,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/bookings")
	public ResponseEntity<List<CabBookingDTO>> findAllBookings(){
		
		List<CabBookingDTO> dtos= service.findAllBookings();
		
		return new ResponseEntity<List<CabBookingDTO>>(dtos,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/")
	public ResponseEntity<String> bookCab(@Valid @RequestBody CabBookingDTO dto){
		
		String success = service.bookCab(dto);		
		
		return new ResponseEntity<String>(success,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value = "/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer bookingId){
		
		String message = service.cancelBooking(bookingId);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	

}
