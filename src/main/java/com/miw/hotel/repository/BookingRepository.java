package com.miw.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Booking;
import com.miw.hotel.model.Client;

public interface BookingRepository extends MongoRepository<Booking, String> {
    
    public List<Booking> findByClient(Client client);
}
