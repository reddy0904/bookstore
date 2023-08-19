package com.example.BookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer_details user;
	
	private String address;
	
	private String status;
	private String producttotal;
	private String discount;
	private String shippingcost;
	private String grandtotal;
	private LocalDateTime orderDateTime;
	private String paymentmethod;
	public Customer_details getUser() {
		return user;
	}
	public void setUser(Customer_details user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProducttotal() {
		return producttotal;
	}
	public void setProducttotal(String producttotal) {
		this.producttotal = producttotal;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(String shippingcost) {
		this.shippingcost = shippingcost;
	}
	public String getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public Orders(Customer_details user, String address, String status, String producttotal, String discount,
			String shippingcost, String grandtotal, LocalDateTime orderDateTime, String paymentmethod) {
		super();
		this.user = user;
		this.address = address;
		this.status = status;
		this.producttotal = producttotal;
		this.discount = discount;
		this.shippingcost = shippingcost;
		this.grandtotal = grandtotal;
		this.orderDateTime = orderDateTime;
		this.paymentmethod = paymentmethod;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
}
