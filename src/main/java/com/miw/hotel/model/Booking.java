package com.miw.hotel.model;

import java.util.Calendar;

public class Booking {

	private int id;
	
	private Calendar startDate;
	
	private Calendar endDate;
	
	private Room room; 
	
	private Client client;
	
	private Status status;
	
	public Booking() {}

	public Booking(int id, Calendar startDate, Calendar endDate, Room room, Client client, Status status) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.client = client;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking {id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", room=" + room
				+ ", client=" + client + ", status=" + status + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
