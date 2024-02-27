package com.cab.bookingService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Entity.CabBooking;
import com.cab.bookingService.Exception.CabException;
import com.cab.bookingService.Repository.CabRepository;
import com.cab.bookingService.Service.CabBookingService;
import com.cab.bookingService.Service.CabBookingServiceImpl;

@SpringBootTest
class CabBookingServiceApplicationTests {
	
	@Mock
	CabRepository repo;
	
	@InjectMocks
	CabBookingService service = new CabBookingServiceImpl();

	
	@Test
	public void shouldBookCab() {
		
		CabBookingDTO booking = new CabBookingDTO();
		booking.setSource("Los Angles");
		booking.setDestination("San Diego");
		booking.setUserMobile(98294734l);
		
		Mockito.when(service.bookCab(booking)).thenReturn("Cab successfully booked");
		
		String actual = service.bookCab(booking);
		
	Assertions.assertEquals("Cab successfully booked", actual);
		
		
	}
	

	
	
	
	
	
	
	@Test
	public void shouldCancelBooking() {
			

		CabBooking booking = new CabBooking();
		booking.setSource("San Jose");
		booking.setDestination("Los Angles");
		booking.setUserMobile(98294734l);
		booking.setBookingId(1);
		booking.setFare(340f);
		booking.setStatus('B');
		booking.setTravelDate(LocalDate.now());
		
		Mockito.when(repo.findById(booking.getBookingId())).thenReturn(Optional.of(booking));
		
		String actual = service.cancelBooking(1);
		
		Assertions.assertEquals("Booking with id: "+ 1 + " has been deleted!", actual);
		
		
	}
	
	

}
