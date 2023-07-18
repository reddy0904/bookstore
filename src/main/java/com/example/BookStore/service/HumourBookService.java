package com.example.BookStore.service;

import java.util.List;

import com.example.BookStore.entity.HumourBook;

public interface HumourBookService {

	List<HumourBook> getAllHumourBooks();
	HumourBook getHumourBookById(int Id);
}
