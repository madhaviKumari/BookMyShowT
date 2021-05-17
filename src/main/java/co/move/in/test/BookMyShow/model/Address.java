package co.move.in.test.BookMyShow.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/*
 There could be multiple cinemahall in same city thats every cinemahall must have a sapret address.
 */
public class Address {
	@NotNull(message = "Street ot be null")
	@NotEmpty(message = "street must not be empty")
	private String street;
	@NotNull(message = "City ot be null")
	@NotEmpty(message = "City must not be empty")
	private String city;
	@NotNull(message = "State ot be null")
	@NotEmpty(message = "State must not be empty")
	private String state;
	@NotNull(message = "country ot be null")
	@NotEmpty(message = "Ciuntry must not be empty")
	private String country;
	private int pin;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	

}
