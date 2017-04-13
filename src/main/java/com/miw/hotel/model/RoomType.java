package com.miw.hotel.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum RoomType {
	
	INDIVIDUAL, DOUBLE, TRIPLE, SUITE;
}
