package com.example.BookStore.service;

import java.util.List;


import com.example.BookStore.entity.AllBook;

public interface AdminService {

	public List<AllBook> getAllBooks();
	public AllBook getBookById(int id);
	public void updateBook(int id,String name,String author,int  price,String booktype,String image);
	public void deleteById(int id);
}
