package com.miw.hotel.model;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {


    private static final int BOOKING_DURATION_CLEAN = 2;

	private static final long SECONDS_HOUR = 3600;


	@Id
	private String id;

	private long startDate;

	private long endDate;

	private Room room;

	private Client client;

	private String status;

	private String reservationCode;

	private double totalPrice;

	public Booking() {
		this.status = Status.BOOKING.name();
	}

	public Booking(String id, long startDate, long endDate, Room room, Client client) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.client = client;
		this.status = Status.BOOKING.name();
		this.totalPrice = 0.0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isBook() {
		return this.status.equals(Status.BOOKING.name());
	}

	public long getDuration() {
		return TimeUnit.MILLISECONDS.toHours(this.endDate - this.startDate);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Booking {id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", room=" + room
				+ ", client=" + client + ", status=" + status + ", totalPrice=" + totalPrice + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + (int) (endDate ^ (endDate >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reservationCode == null) ? 0 : reservationCode.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + (int) (startDate ^ (startDate >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (endDate != other.endDate)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reservationCode == null) {
			if (other.reservationCode != null)
				return false;
		} else if (!reservationCode.equals(other.reservationCode))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (startDate != other.startDate)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}

	public boolean valid() {
		if (this.startDate == this.endDate)
			return false;
		if (this.room == null)
			return false;
		if (this.client == null)
			return false;

		return true;
	}

	public void putTotalPriceBook(){  
        if ((this.startDate<this.endDate)&&(this.room!=null)&&(this.room.getPricePerHour()!=null)){
            long priceCaluclate= this.room.getPricePerHour().longValue()*this.getDuration();
            this.setTotalPrice(priceCaluclate);
        }
            
     }

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

    public long timeEndWithBookToClean(){
        Calendar add3hours = Calendar.getInstance();
        add3hours.setTimeInMillis(this.endDate);
        add3hours.add(Calendar.HOUR_OF_DAY, (int) BOOKING_DURATION_CLEAN);
        return add3hours.getTimeInMillis();
    }
    
}
