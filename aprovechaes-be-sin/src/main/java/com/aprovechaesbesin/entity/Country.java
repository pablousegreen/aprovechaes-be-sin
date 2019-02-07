package com.aprovechaesbesin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Country")
public class Country {
	
	@Id
	private String id;
	private String name;
	private String capital;
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
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Country(String name, String capital) {
		super();
		this.name = name;
		this.capital = capital;
	}
	

}
