package com.miw.hotel.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Client {

	@Id ObjectId databaseId;

	private String id;
	
	private String name;
	
	private String surname;
	
	private String movil; //+34 XXX XXX XXX
	
	private String email;
	
	private String address;
	
	private String nif;
	
	public Client(){}

	public Client(String id, String name, String surname, String movil, String email, String address, String nif) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.movil = movil;
		this.email = email;
		this.address = address;
		this.nif = nif;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return "Client {id=" + id + ", name=" + name + ", surname=" + surname + ", movil=" + movil + ", email=" + email
				+ ", address=" + address + ", nif=" + nif + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + id;
		result = prime * result + ((movil == null) ? 0 : movil.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (movil == null) {
			if (other.movil != null)
				return false;
		} else if (!movil.equals(other.movil))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}
	
	
	
	
}
