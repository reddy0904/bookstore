package com.example.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.Book;
import com.example.BookStore.entity.HumourBook;
import com.example.BookStore.entity.MyBooks;
import com.example.BookStore.service.HumourBookService;
import com.example.BookStore.service.MyBookListService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private HumourBookService humourBookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/availablebooks")
	public String availablebooks() {
		return "user/availablebooks";
	}

	@GetMapping("/humourbooks")
	public ModelAndView humourbooks() {
		List<HumourBook> list = humourBookService.getAllHumourBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("/user/humourbooks");
		m.addObject("humourbook", list);
		return m;
	}

//	@GetMapping("/mybooks")
//	public String myBooks() {
//		return "/user/mybooks";
//	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int Id) {
		System.out.println(Id);
		HumourBook book = humourBookService.getHumourBookById(Id);
		MyBooks myBook = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.save(myBook);
		return "redirect:/user/humourbooks";
	}

//	@GetMapping("/mybooks")
//	public String myBooks(Model model) {
//		List<MyBooks> myBooks = myBookListService.getMyAllBooks();
//		model.addAttribute("book", myBooks);
//		return "redirect:/user/mybooks";
//	}
	@GetMapping("/mybooks")
    public ModelAndView getAllBooks(){
        List<MyBooks> list = myBookListService.getMyAllBooks();
        ModelAndView m = new ModelAndView();
        m.setViewName("/user/mybooks");
        m.addObject("book", list);
        return m;
	}
	@RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int Id){
        myBookListService.deleteById(Id);
        return "redirect:/user/mybooks";
    }
}
