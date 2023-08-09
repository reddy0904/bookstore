package com.example.BookStore.Trail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.AllBook;
import com.example.BookStore.service.ActionBookService;
import com.example.BookStore.service.AddNewBook;

@Controller
public class Trail {
	@Autowired
	private ActionBookService actionBookService;
	@GetMapping("/trail")
	public ModelAndView humourbooks() {
		List<AllBook> list = actionBookService.getAllBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("trail");
		m.addObject("actionbook", list);
		return m;
	}
	
}