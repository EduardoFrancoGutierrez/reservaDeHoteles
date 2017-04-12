package com.miw.hotel.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelTest {

	@Test
	public void testHotel() {
		assertNotNull(new Hotel());
	}

	@Test
	public void testHotelIntStringStringStringStringString() {
		Hotel hotel = new Hotel(1, "Melia1", "28045", "Juan", "Perez", "imagen");
		assertNotNull(hotel);
		assertEquals(1, hotel.getId());
		assertEquals("Melia1", hotel.getName());
		assertEquals("28045", hotel.getPostalCode());
		assertEquals("Juan", hotel.getNameDirector());
		assertEquals("Perez", hotel.getLastNameDirector());
		assertEquals("imagen", hotel.getImage());
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(new Hotel(1, "Melia1", "28045", "Juan", "Perez", "imagen"), new Hotel(1, "Melia1", "28045", "Juan", "Perez", "imagen"));
		assertNotEquals(new Hotel(1, "Melia1", "28045", "Juan", "Perez", "imagen"), new Hotel(1, "Melia2", "28045", "Juan", "Perez", "imagen"));
		assertNotEquals(new Hotel(1, "Melia1", "28045", "Juan", "Perez", "imagen"), new Hotel(2, "Melia1", "28045", "Juan", "Perez", "imagen"));
	}

}
