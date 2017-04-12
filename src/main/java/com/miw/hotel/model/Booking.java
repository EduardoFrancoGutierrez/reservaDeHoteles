package com.miw.hotel.model;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Booking {

	private int id;
	
	private Calendar startDate;
	
	private Calendar endDate;
	
	private Room room; 
	
	private Client client;
	
	private Status status;
	
	public Booking() {}

	public Booking(int id, Calendar startDate, Calendar endDate, Room room, Client client) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.client = client;
		this.status = Status.BOOKING;
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
	
	public boolean isBook() {
		return this.status == Status.BOOKING;
	}
	
	public long getDuration() {
		return TimeUnit.MILLISECONDS.toHours(this.endDate.getTimeInMillis() - this.startDate.getTimeInMillis());
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
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
	
	
	
}
