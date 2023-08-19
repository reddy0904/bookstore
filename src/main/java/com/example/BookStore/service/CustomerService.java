package com.example.BookStore.service;

import com.example.BookStore.entity.*;
public interface CustomerService {
	public Customer_details createuser(Customer_details details);
	public boolean checkEmail(String email);
	public Customer_details getUserByUsername(String username);
	public void sendVerificationMail(Customer_details details);
	public boolean verifyAccount(String code);
	public Customer_details getUserById(int id);
	public boolean checkPassword(int id,String ps);
	public void updateProfile(int id,String name,String email,String phoneno);
	public void sendChangePasswordMail(String email);
	public void changePassword(int id, String password);
	public Customer_details getDetails();
}
