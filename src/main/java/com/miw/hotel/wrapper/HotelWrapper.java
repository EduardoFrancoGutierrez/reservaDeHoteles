package com.miw.hotel.wrapper;

import java.math.BigDecimal;
import java.util.List;

import com.miw.hotel.model.Room;

public class HotelWrapper {
	
	private List<Room> rooms;
	
	private BigDecimal minPrice = BigDecimal.ZERO; 
	
	private String name;
	
	private String image;
	
	public HotelWrapper() {}

	public HotelWrapper(String name, String image, List<Room> rooms) {
		this.name = name;
		this.image = image;		
		this.rooms = rooms;
		for(Room room : rooms) {			
			if(room.getPricePerHour().compareTo(minPrice) < 0 || minPrice.equals(BigDecimal.ZERO)){
				minPrice = room.getPricePerHour();
			}
		}
	}

	@Override
	public String toString() {
		return "HotelWrapper {rooms=" + rooms + ", minPrice=" + minPrice + ", name=" + name + ", image=" + image + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
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
		HotelWrapper other = (HotelWrapper) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (minPrice == null) {
			if (other.minPrice != null)
				return false;
		} else if (!minPrice.equals(other.minPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	
	
	
}
