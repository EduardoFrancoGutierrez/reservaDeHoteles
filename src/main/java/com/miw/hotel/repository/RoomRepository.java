package com.miw.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{

	Room findById(String id);
	
	List<Room> findByHotel_Id(String id);
}
