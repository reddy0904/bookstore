package com.example.BookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.AllBook;

public interface AllBookRepository  extends JpaRepository<AllBook, Integer>  {


	public List<AllBook> findByType(String type);
	public AllBook findById(int id);
}
