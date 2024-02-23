package com.cab.bookingService.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class CabBookingDTO {
	
	private Integer	bookingId;
	@Pattern(regexp = "(San Jose|San Francisco|Los Angles|Pheonix)", message = "Invalid Source !")
	private String source;
	@Pattern(regexp = "(San Jose|San Diego|Los Angles|Tucson)", message = "Invalid Destination !")
	private String destination;
	private Float fare;
	private LocalDate travelDate;
	@Min(value = 99999,message = "Enter a valid phone number")
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
	
	@Override
    public String toString() {
        return "BookingDTO----->  {" +
                "bookingId= " + bookingId +
                ", source= '" + source + '\'' +
                ", destination= '" + destination + '\'' +
                ", fare= " + fare +
                ", travelDate= " + travelDate +
                ", userMobile= " + userMobile +
                ", status= " + status +
                '}';	
	
	}

}
