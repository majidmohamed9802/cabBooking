package com.cab.bookingService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cab.bookingService.DTO.CabBookingDTO;
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
		
		assertEquals("Cab successfully booked", actual);
		
		
	}
	
	

}
