package com.example.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.ActionBook;
import com.example.BookStore.entity.MyBooks;
import com.example.BookStore.service.ActionBookService;
import com.example.BookStore.service.MyBookListService;

@Controller
@RequestMapping("/user")
public class ActionBookController {
	@Autowired
	private ActionBookService actionBookService;
	
	@Autowired
	private MyBookListService myBookListService;
	@GetMapping("/actionbooks")
	public ModelAndView humourbooks() {
		List<ActionBook> list = actionBookService.getAllActionBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("/user/actionbooks");
		m.addObject("actionbook", list);
		return m;
	}
	@RequestMapping("/myactionList/{id}")
	public String getMyList(@PathVariable("id") int Id) {
		System.out.println(Id);
		ActionBook book = actionBookService.getActionBookById(Id);
		MyBooks myBook = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.save(myBook);
		return "redirect:/user/actionbooks";
	}
}
