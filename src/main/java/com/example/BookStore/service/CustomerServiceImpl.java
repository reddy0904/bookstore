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
	@Override
	public Customer_details getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(username);
	}
	@Override
	public Customer_details getUserById(int id) {
		
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}
	@Override
	public boolean checkPassword(int id,String ps) {
		// TODO Auto-generated method stub
		Customer_details d=userRepo.findById(id);
		if(passwordEncode.matches(ps,d.getPassword())) {
			return true;
		}
		return false;
	}
	@Override
	public void updateProfile(int id,String name, String email, String phoneno) {
		// TODO Auto-generated method stub
		Customer_details details =userRepo.findById(id);
		details.setFullname(name);
		details.setEmail(email);
		details.setPhoneno(phoneno);
		userRepo.save(details);
		
	}
	
}
