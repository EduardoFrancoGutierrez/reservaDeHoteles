package com.miw.hotel.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Hotel {

	@Id ObjectId databaseId;

	private String id;

	private String name;
	
	private String postalCode;
	
	private String nameDirector;
	
	private String lastNameDirector;
	
	private String image;
	
	public Hotel(){}

	public Hotel(String id, String name, String postalCode, String nameDirector, String lastNameDirector, String image) {
		super();
		this.id = id;
		this.name = name;
		this.postalCode = postalCode;
		this.nameDirector = nameDirector;
		this.lastNameDirector = lastNameDirector;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNameDirector() {
		return nameDirector;
	}

	public void setNameDirector(String nameDirector) {
		this.nameDirector = nameDirector;
	}

	public String getLastNameDirector() {
		return lastNameDirector;
	}

	public void setLastNameDirector(String lastNameDirector) {
		this.lastNameDirector = lastNameDirector;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Hotel {id=" + id + ", name=" + name + ", postalCode=" + postalCode + ", nameDirector=" + nameDirector
				+ ", lastNameDirector=" + lastNameDirector + ", image=" + image + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Hotel other = (Hotel) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

}
