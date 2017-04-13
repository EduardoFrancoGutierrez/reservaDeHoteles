package com.miw.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Hotel;


public interface HotelRepository extends MongoRepository<Hotel, String> {

    public Hotel findByName(String name);
}
