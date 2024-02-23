package com.cab.bookingService.Service;

import java.util.List;

import com.cab.bookingService.DTO.CabBookingDTO;
import com.cab.bookingService.Exception.CabException;

public interface CabBookingService {

	public String bookCab(CabBookingDTO dto);
	public CabBookingDTO findBookingByNumber(long userMobile) throws CabException;
	public String cancelBooking(Integer bookingId);
	public List<CabBookingDTO> findAllBookings(); 
	
	
}
