package com.miw.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miw.hotel.model.Client;


public interface ClientRepository extends MongoRepository<Client, String>{

	Client findById(String id);
		
	Client findByNif(String nif);

}
