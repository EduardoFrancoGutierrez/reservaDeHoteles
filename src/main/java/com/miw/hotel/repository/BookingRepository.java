package com.miw.hotel.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

    public Booking findById(String id);
    
    public List<Booking> findByClient_Id(String id);
 
}
