package com.cab.bookingService.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cab.bookingService.Entity.CabBooking;

@Repository
public interface CabRepository extends CrudRepository<CabBooking, Integer>{
	
	public CabBooking findByUserMobile(Long userMobile);
	
	@Query("SELECT b FROM CabBooking b")
	public List<CabBooking> findAllBookings();

}
