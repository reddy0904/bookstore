package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookStore.entity.Address;
import com.example.BookStore.repository.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	public AddressRepository addressRepo;
	
	@Override
	public List<Address> allSavedAddress( int id) {
		// TODO Auto-generated method stub
        
		return addressRepo.findAddressByUserId(id);
	}
	

}
