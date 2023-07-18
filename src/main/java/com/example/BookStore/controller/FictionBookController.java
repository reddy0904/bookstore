package com.example.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.ActionBook;
import com.example.BookStore.entity.FictionBook;

import com.example.BookStore.entity.MyBooks;
import com.example.BookStore.service.ActionBookService;
import com.example.BookStore.service.FictionBookService;
import com.example.BookStore.service.MyBookListService;

@Controller
@RequestMapping("/user")
public class FictionBookController {
	@Autowired
	private FictionBookService fictionBookService;
	
	@Autowired
	private MyBookListService myBookListService;
	@GetMapping("/fictionbooks")
	public ModelAndView humourbooks() {
		List<FictionBook> list = fictionBookService.getAllFictionBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("/user/fictionbooks");
		m.addObject("fictionbook", list);
		return m;
	}
	@RequestMapping("/myfictionList/{id}")
	public String getMyList(@PathVariable("id") int Id) {
		System.out.println(Id);
		FictionBook book = fictionBookService.getFictionBookById(Id);
		MyBooks myBook = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.save(myBook);
		return "redirect:/user/fictionbooks";
	}
}
