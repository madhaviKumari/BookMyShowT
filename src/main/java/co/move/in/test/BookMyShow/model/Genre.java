package co.move.in.test.BookMyShow.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Genre {
	@Id
	private String id;
	@NotNull(message = "Category must ot be null")
	@NotEmpty(message = "Category must not be empty")
	private String category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
