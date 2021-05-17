package co.move.in.test.BookMyShow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "roles")
public class Role {
	  
	  @Id
	  private String id;
	  private ERole name;
	  private String description;
	  public Role() {}
	  public Role(String id, ERole name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	  }
	  public Role(ERole name) {
	    this.name = name;
	  }
	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }
	  public ERole getName() {
	    return name;
	  }
	  public void setName(ERole name) {
	    this.name = name;
	  }
	  public String getDescription() {
		return description;
	  }
	  public void setDescription(String description) {
		this.description = description;
	  }
	  
}


