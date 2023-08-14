package com.example.BookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orderdetails")
@Data
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer_details user;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private AllBook allBook;
	
	private int quantity;
	private int subtotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer_details getUser() {
		return user;
	}
	public void setUser(Customer_details user) {
		this.user = user;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public AllBook getAllBook() {
		return allBook;
	}
	public void setAllBook(AllBook allBook) {
		this.allBook = allBook;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public OrderDetails(Customer_details user, Orders order, AllBook allBook, int quantity, int subtotal) {
		super();
		this.user = user;
		this.order = order;
		this.allBook = allBook;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
