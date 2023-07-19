package com.example.BookStore.service;

import com.example.BookStore.entity.*;
public interface CustomerService {
	public Customer_details createuser(Customer_details details);
	public boolean checkEmail(String email);
	public Customer_details getUserByUsername(String username);
}
