package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.HumourBook;
import com.example.BookStore.repository.HumourBookRepository;

@Service
public class HumourBookServiceImpl implements HumourBookService{

    @Autowired
    private HumourBookRepository humourBookRepository;
	@Override
	public List<HumourBook> getAllHumourBooks() {
		// TODO Auto-generated method stub
		return humourBookRepository.findAll();

	}
	@Override
	public HumourBook getHumourBookById(int Id) {
		// TODO Auto-generated method stub
		return humourBookRepository.findById(Id).get();
	}

}
