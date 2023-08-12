package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
