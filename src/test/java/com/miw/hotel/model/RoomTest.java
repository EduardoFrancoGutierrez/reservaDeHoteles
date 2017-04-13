package com.miw.hotel.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
	
	private Room room1;
	private Room room2;
	private Room room3;
	private Hotel hotel1;
	
	@Before
	public void before(){
		hotel1 = new Hotel(1+"", "Melia1", "28045", "Juan", "Perez", "imagen");
		room1 = new Room(1564782+"", hotel1, new BigDecimal(12), RoomType.INDIVIDUAL);
		room2 = new Room(1564782+"", hotel1, new BigDecimal(12), RoomType.INDIVIDUAL);
		Hotel hotel2 = new Hotel(2+"", "Melia2", "28045", "Juan", "Perez", "imagen");
		room3 = new Room(1564782+"", hotel2, new BigDecimal(12), RoomType.INDIVIDUAL);
	}
	
	@Test
	public void testRoom(){
		assertNotNull(new Room());
	}
	
	@Test
	public void testRoomWithFields(){
		assertNotNull(room1);
		assertEquals(1564782+"", room1.getId());
		assertEquals(hotel1, room1.getHotel());
		assertEquals(new BigDecimal(12), room1.getPricePerHour());
		assertEquals(RoomType.INDIVIDUAL.name(), room1.getType());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(room1, room2);
		assertNotEquals(room1, room3);
	}

}
