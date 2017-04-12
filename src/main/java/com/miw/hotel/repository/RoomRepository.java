package com.miw.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{

	Room findById(String id);
}
