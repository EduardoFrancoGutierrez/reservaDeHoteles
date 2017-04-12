package com.miw.hotel.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.miw.hotel.exceptions.InvalidBookingException;
import com.miw.hotel.exceptions.InvalidRoomException;
import com.miw.hotel.model.Booking;

public class BookingControllerTest {
	
	@Autowired
	private BookingController bookingController;

	@Test
	public void testGetAllBooks() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelBooking() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBook() {
		Booking booking = new Booking();
		
		try {
			bookingController.createBook(booking);
		} catch (InvalidRoomException | InvalidBookingException e) {
			fail();
		}
	}

}
