package com.miw.hotel;

import org.springframework.data.mongodb.repository.MongoRepository;




public interface HotelRepository extends MongoRepository<Hotel, String> {

    public Hotel findByName(String name);
}
