package com.example.BookStore.service;

import java.util.List;

import com.example.BookStore.entity.ActionBook;

public interface ActionBookService {

	List<ActionBook> getAllActionBooks();
	ActionBook getActionBookById(int Id);
}

