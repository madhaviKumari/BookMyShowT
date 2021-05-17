package co.move.in.test.BookMyShow.dto;

import javax.validation.constraints.Email;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class ClientDTO {
		@NotNull(message = "Phone number mst ot be null")
		@NotEmpty(message = "Phone number must not be empty")
		@Pattern(regexp = "((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}", message="Provide a valid phone number with country code")
		public String phone;
		@NotNull
		@NotEmpty
		@Email(message = "Provide a valid Email address")
	    public String email;
		@NotNull
		@NotEmpty
		//@Pattern(regexp = "^[\\\\p{L} .'-]+$" , message="Provide a valid name")
	    public String fullName;
		@NotNull
		@NotEmpty(message="Password must not be empty")
		@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message="Provide a strong password")
	    public String password;
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}//madhavi@35
	    
	    
}

