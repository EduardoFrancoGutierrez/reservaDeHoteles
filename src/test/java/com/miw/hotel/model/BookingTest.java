package com.miw.hotel.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	private Booking booking;
	private Room room;
	private Client client;
	private Calendar startDate;
	private Calendar endDate;
	
	private static final long BOOKING_DURATION = 2;
	
	@Before
	public void before(){
		Hotel hotel1 = new Hotel(1+"", "Melia1", "28045", "Juan", "Perez", "imagen");
		room = new Room(1564782+"", hotel1, new BigDecimal(12), RoomType.INDIVIDUAL);
		client = new Client(1+"", "Juan", "", "666666666", "pepe@gmail.com", "Calle falsa 123", "00000000A");
		startDate = Calendar.getInstance();
		endDate = Calendar.getInstance();
		endDate.add(Calendar.HOUR_OF_DAY, (int) BOOKING_DURATION);		
		booking = new Booking(1+"", startDate.getTimeInMillis(), endDate.getTimeInMillis(), room, client);		
	}
	

	@Test
	public void testBooking() {
		assertNotNull(new Booking());
	}

	@Test
	public void testBookingIntCalendarCalendarRoomClient() {		
		assertNotNull(booking);
		assertEquals(1+"", booking.getId());
		assertEquals(startDate.getTimeInMillis(), booking.getStartDate());
		assertEquals(endDate.getTimeInMillis(), booking.getEndDate());
		assertEquals(room, booking.getRoom());
		assertEquals(client, booking.getClient());
		assertEquals(Status.BOOKING.name(), booking.getStatus());
		assertEquals(BOOKING_DURATION, booking.getDuration());
	}

	@Test
	public void testEqualsObject() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, (int) BOOKING_DURATION);
		assertEquals(booking, new Booking(1+"", Calendar.getInstance().getTimeInMillis(), cal.getTimeInMillis(), room, client));
		cal.add(Calendar.HOUR_OF_DAY, 1);
		assertNotEquals(booking, new Booking(1+"", Calendar.getInstance().getTimeInMillis(), cal.getTimeInMillis(), room, client));
	}
	
	@Test
	public void testBooked() {		
		assertTrue(booking.isBook());
	}

}
