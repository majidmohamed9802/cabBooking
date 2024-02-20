package com.cab.bookingService.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Entity.CabBooking;
import com.cab.bookingService.Exception.CabException;
import com.cab.bookingService.Repository.CabRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CabBookingServiceImpl implements CabBookingService {
	
	@Autowired
	CabRepository cabRepo ;

	
	public String bookCab(CabBookingDTO dto) {
		
		try {
		CabBooking booking = new CabBooking();
		
		booking.setDestination(dto.getDestination());
		booking.setSource(dto.getSource());
		booking.setUserMobile(dto.getUserMobile());
		
		booking.setStatus('B');
		booking.setTravelDate(LocalDate.now());
		
		float fare =booking.calculateFare(dto.getSource(), dto.getDestination());

		if(fare==0) {throw new CabException("-------FARE IS 0---------------");}
		
		booking.setFare(fare);
		
		cabRepo.save(booking);
		
		String success = "Cab successfully booked";
		
		return success;
		}catch(Exception e) {
			return e.getMessage()+"   error in SERVICE class";
		}
		
	}

}
