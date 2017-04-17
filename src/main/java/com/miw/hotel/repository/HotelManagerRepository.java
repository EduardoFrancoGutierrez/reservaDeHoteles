package com.miw.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.HotelManager;

public interface HotelManagerRepository extends MongoRepository<HotelManager, String> {
	
	HotelManager findByHotel_Id(String id);

}
