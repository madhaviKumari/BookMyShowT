package co.move.in.test.BookMyShow.model;

import javax.validation.Valid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class CinemaHall {
	
	@Id
	private String id;
	@NotNull(message = "Name must ot be null")
	@NotEmpty(message = "Name  must not be empty")
	@Indexed
	private String name;
	@Valid
	private Address address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
