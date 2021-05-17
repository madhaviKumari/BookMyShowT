package co.move.in.test.BookMyShow.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginRequest {
	
	@NotNull(message="username can not be null")
	@NotEmpty(message="username can not be empty")
	public String username;
	
	@NotNull(message="passwordcan not be null")
	@NotEmpty(message="password can not be empty")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message="Provide a strong password")
    public String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
