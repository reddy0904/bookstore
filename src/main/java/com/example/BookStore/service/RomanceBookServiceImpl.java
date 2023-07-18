package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.RomanceBook;
import com.example.BookStore.repository.RomanceBookRepository;

@Service
public class RomanceBookServiceImpl implements RomanceBookService {
	 @Autowired
	  private RomanceBookRepository romanceBookRepository;
	@Override
	public List<RomanceBook> getAllRomanceBooks() {
		// TODO Auto-generated method stub
		return romanceBookRepository.findAll();
	}

	@Override
	public RomanceBook getRomanceBookById(int Id) {
		// TODO Auto-generated method stub
		return romanceBookRepository.findById(Id).get();
	}

}
