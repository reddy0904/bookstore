package com.example.BookStore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.AllBook;
import com.example.BookStore.entity.Cart;
import com.example.BookStore.entity.Customer_details;
import com.example.BookStore.repository.CartRepository;
import com.example.BookStore.service.ActionBookService;
import com.example.BookStore.service.CartService;
import com.example.BookStore.service.CustomerService;

@Controller
@RequestMapping("/user")
public class ActionBookController {
	@Autowired
	private ActionBookService actionBookService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepo;
	
	@GetMapping("/actionbooks")
	public ModelAndView humourbooks() {
		List<AllBook> list = actionBookService.getAllBooks();
		List<Cart> list2 = cartService.getBooksForLoggedInUser();;
		ModelAndView m = new ModelAndView();
		m.setViewName("/user/actionbooks");
		m.addObject("actionbook", list);
		m.addObject("cartitem",list2);
		return m;
	}
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@RequestMapping("/myactionList/{id}")
	public String getMyList(@PathVariable("id") int Id,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
		AllBook book = actionBookService.getAllBookById(Id);
		
		if(!(cartRepo.existsByUserIdAndAllBookId(loggedInUser.getId(),Id))){
		Cart myBook = new Cart(book,loggedInUser);
		cartService.save(myBook);
		}
		else {
			session.setAttribute("msg","Book Already added!");
		}
		return "redirect:/user/actionbooks";
	}

}
