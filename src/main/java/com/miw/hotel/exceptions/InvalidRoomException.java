package com.miw.hotel.exceptions;

public class InvalidRoomException extends Exception {

	private static final long serialVersionUID = 1744130173408273858L;

	private String message = "La habitacón no es válida";
	
	@Override
	public String getMessage() {
		return message;
	}
}
