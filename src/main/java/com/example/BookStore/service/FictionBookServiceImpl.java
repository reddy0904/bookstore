package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.FictionBook;
import com.example.BookStore.repository.FictionBookRepository;

@Service
public class FictionBookServiceImpl implements FictionBookService{

	@Autowired
    private FictionBookRepository fictionBookRepository;
	@Override
	public List<FictionBook> getAllFictionBooks() {
		// TODO Auto-generated method stub
		return fictionBookRepository.findAll();
	}

	@Override
	public FictionBook getFictionBookById(int Id) {
		// TODO Auto-generated method stub
		return fictionBookRepository.findById(Id).get();
	}
		
}
