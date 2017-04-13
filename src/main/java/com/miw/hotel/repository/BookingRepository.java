package com.miw.hotel.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

    Booking findById(String id);    

    Booking findTopOrderById();   

    List<Booking> findByClient_Id(String id);
}
