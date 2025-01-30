package org.formation.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Coffee {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "coffee cannot be null")
	@Schema(
			description = "Represents a coffee",
			example = "Grand mere"
			
			)
	private String name;
	
	public Coffee() {
	}
	
	public Coffee(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + "]";
	}
	
	
}
