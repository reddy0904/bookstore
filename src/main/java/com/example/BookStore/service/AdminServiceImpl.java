package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookStore.entity.AllBook;
import com.example.BookStore.repository.AllBookRepository;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AllBookRepository allBookRepo;
	
	@Override
	public List<AllBook> getAllBooks() {
		// TODO Auto-generated method stub
		return allBookRepo.findAll();
	}

	@Override
	public AllBook getBookById(int id) {
		// TODO Auto-generated method stub
		return allBookRepo.findById(id);
	}

	@Override
	public void updateBook(int id,String name, String author, int price, String booktype,String image) {
		// TODO Auto-generated method stub
		AllBook b=allBookRepo.findById(id);
		b.setName(name);
		b.setAuthor(author);
		b.setPrice(price);
		b.setType(booktype);
		b.setImage(image);
		allBookRepo.save(b);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		allBookRepo.deleteById(id);
		
	}

}
