package com.example.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.RomanceBook;
import com.example.BookStore.entity.MyBooks;
import com.example.BookStore.service.RomanceBookService;
import com.example.BookStore.service.MyBookListService;

@Controller
@RequestMapping("/user")
public class RomanceBookController {
	@Autowired
	private RomanceBookService romanceBookService;
	
	@Autowired
	private MyBookListService myBookListService;
	@GetMapping("/romancebooks")
	public ModelAndView humourbooks() {
		List<RomanceBook> list = romanceBookService.getAllRomanceBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("/user/romancebooks");
		m.addObject("romancebook", list);
		return m;
	}
	@RequestMapping("/myromanceList/{id}")
	public String getMyList(@PathVariable("id") int Id) {
		System.out.println(Id);
		RomanceBook book = romanceBookService.getRomanceBookById(Id);
		MyBooks myBook = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.save(myBook);
		return "redirect:/user/romancebooks";
	}
}
