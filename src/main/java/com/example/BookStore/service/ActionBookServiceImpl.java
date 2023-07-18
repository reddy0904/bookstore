package com.example.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.ActionBook;
import com.example.BookStore.repository.ActionBookRepository;
@Service
public class ActionBookServiceImpl implements ActionBookService{

	 @Autowired
	    private ActionBookRepository actionBookRepository;
	@Override
	public List<ActionBook> getAllActionBooks() {
		// TODO Auto-generated method stub
		return actionBookRepository.findAll();
	}

	@Override
	public ActionBook getActionBookById(int Id) {
		// TODO Auto-generated method stub
		return actionBookRepository.findById(Id).get();
	}

}
