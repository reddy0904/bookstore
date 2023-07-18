package com.example.BookStore.service;

import java.util.List;

import com.example.BookStore.entity.FictionBook;

public interface FictionBookService {
	List<FictionBook> getAllFictionBooks();
	FictionBook getFictionBookById(int Id);
}
