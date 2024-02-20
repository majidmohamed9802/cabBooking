package com.cab.bookingService.Service;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Exception.CabException;

public interface CabBookingService {

	public String bookCab(CabBookingDTO dto);
	
}
