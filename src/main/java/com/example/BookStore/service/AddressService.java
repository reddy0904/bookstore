package com.example.BookStore.service;

import java.util.List;
import com.example.BookStore.entity.Address;

public interface AddressService {
	public List<Address> allSavedAddress(int id);
}
