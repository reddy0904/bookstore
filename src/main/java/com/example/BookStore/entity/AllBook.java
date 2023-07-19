package com.example.BookStore.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "allbook")
@Data
public class AllBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String price;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public AllBook(int id, String name, String author, String price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.type = type;
	}

	public AllBook() {
		super();
		// TODO Auto-generated constructor stub
	}

}