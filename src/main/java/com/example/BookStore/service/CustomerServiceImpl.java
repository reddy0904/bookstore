package com.example.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.BookStore.entity.*;
import com.example.BookStore.repository.*;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public Customer_details createuser(Customer_details details) {
		
		details.setPassword(passwordEncode.encode(details.getPassword()));
		return userRepo.save(details);
	}
	@Override
	public boolean checkEmail(String email) {
		
		return userRepo.existsByEmail(email);
	}
	
}
