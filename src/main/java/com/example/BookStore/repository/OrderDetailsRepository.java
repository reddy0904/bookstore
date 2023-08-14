package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
