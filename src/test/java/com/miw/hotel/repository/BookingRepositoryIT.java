package com.miw.hotel.repository;

import static org.junit.Assert.*;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miw.hotel.model.Booking;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookingRepositoryIT {

	@Autowired
	private BookingRepository bookingRepository;
	
	private ObjectId bookingId;
	
	@Before
	public void before() {
		bookingId = new ObjectId(); 
		
		Booking booking = new Booking();
		booking.setId(bookingId.toString());
		
		bookingRepository.save(booking);
		
	}
	
	@Test
	public void testFindById() {
		assertEquals(bookingId.toString(), bookingRepository.findById(bookingId.toString()).getId());
	}
	
	@Test
	public void testFindAll() {
		assertFalse(bookingRepository.findAll().isEmpty());
	}
	
	@After
	public void after() {
		bookingRepository.delete(bookingId.toString());
	}
}
