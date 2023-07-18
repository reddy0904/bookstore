package com.example.BookStore.service;

import java.util.List;

import com.example.BookStore.entity.RomanceBook;

public interface RomanceBookService {
	List<RomanceBook> getAllRomanceBooks();
	RomanceBook getRomanceBookById(int Id);
}
