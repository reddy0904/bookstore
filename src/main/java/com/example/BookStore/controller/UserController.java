package com.example.BookStore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.Cart;
import com.example.BookStore.service.CartService;
import com.example.BookStore.service.MyBookListService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/availablebooks")
	public String availablebooks() {
		return "user/availablebooks";
	}

	@GetMapping("/mybooks")
    public ModelAndView getAllBooks(){
        List<Cart> list = cartService.getBooksForLoggedInUser();
        ModelAndView m = new ModelAndView();
        m.setViewName("/user/mybooks");
        m.addObject("cart", list);
        return m;
	}
	@RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int Id){
        myBookListService.deleteById(Id);
        return "redirect:/user/mybooks";
    }
}
