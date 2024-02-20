package com.cab.bookingService.Service;

import java.time.LocalDate;
import java.util.Optional;

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
			return e.getMessage()+" <----------------ERROR OCCURED";
		}
		
	}
	

	
	public String cancelBooking(Integer bookingId)  {
		
		try {		
		Optional<CabBooking> optional = cabRepo.findById(bookingId);
		CabBooking booking = optional.orElseThrow(()-> new CabException("Booking doesnt exist"));
		cabRepo.delete(booking);		
		return "Booking with id: "+ bookingId+ " has been deleted!!!!!!!!!!!!!!!!!" ;
	}
		catch(Exception e) {
			return e.getLocalizedMessage()+ " <----------------ERROR OCCURED";
		}
		
	}

	@Override
	public CabBookingDTO findBookingByNumber(long userMobile) throws CabException {

		CabBooking booking = cabRepo.findByUserMobile(userMobile);
		
		if(booking==null) {throw new CabException("Booking doesnt exist with this number");}
		
		CabBookingDTO dto = new CabBookingDTO();
		dto.setBookingId(booking.getBookingId());
		dto.setDestination(booking.getDestination());
		dto.setFare(booking.getFare());
		dto.setSource(booking.getSource());
		dto.setStatus(booking.getStatus());
		dto.setTravelDate(booking.getTravelDate());
		dto.setUserMobile(booking.getUserMobile());
		
		
		
		return dto;
	}

	
	
	
	

}
