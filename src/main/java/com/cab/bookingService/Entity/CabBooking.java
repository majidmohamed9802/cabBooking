package com.cab.bookingService.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class CabBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	bookingId;
	private String source;
	private String destination;
	private Float fare;
	private LocalDate travelDate;
	private Long userMobile;
	private Character status;
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public Long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	
	public float calculateFare(String source, String destination ) {
		
		float Fare=0;
		
		if(source.equals("San Jose") && destination.equals("Los Angles")) {Fare+=340f;}
		if(source.equals("San Francisco") && destination.equals("San Jose")) {Fare+=48F;}
		if(source.equals("Los Angles") && destination.equals("San Diego")) {Fare+=120f;}
		if(source.equals("Pheonix") && destination.equals("Tucson")) {Fare+=114f;}
		
		System.out.println(Fare);
		
		return Fare;
	}	
	

}
