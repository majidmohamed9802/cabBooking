package com.cab.bookingService.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cab.bookingService.Entity.CabBooking;

@Repository
public interface CabRepository extends CrudRepository<CabBooking, Integer>{

}
