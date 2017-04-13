package com.miw.hotel.exceptions;

public class InvalidBookingException extends Exception {

	private static final long serialVersionUID = -8090206424075710622L;
	
	private String message = "La reserva no es válida";

	@Override
	public String getMessage() {
		return message;
	}
	
}
