package com.miw.hotel.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HotelManagerRepositoryIT {

	private static final String HOTEL_VALID_ID = "58ee1b14734d1d271d37ddd2";
	
	@Autowired
	private HotelManagerRepository hotelManagerRepository;
	

	@Test
	public void testFindByHotelId() {
		assertNotNull(hotelManagerRepository.findByHotel_Id(HOTEL_VALID_ID));
	}

}
