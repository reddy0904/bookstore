package com.example.BookStore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookStore.service.*;
import com.example.BookStore.entity.*;
@Controller
public class HomeController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
    public String home(){
        return "home";
    }
	
	@GetMapping("/signin")
    public String signin(){
        return "signin";
	}
	@GetMapping("/register")
    public String register(){
        return "register";
	}
	
	@PostMapping("/createuser")
	public String createuser(@ModelAttribute Customer_details details,HttpSession session) {
		boolean f = customerService.checkEmail(details.getEmail());
		
		if (f) {
			session.setAttribute("msg","Email Id alreday exists");
			return "redirect:/register";
		}
		else {
		Customer_details cs=customerService.createuser(details);
		if(cs!=null) {
			System.out.println("Success");
			session.setAttribute("msg1","Successfully Registered!!");
//			return "redirect:/customer_sign";
		}
		}
		return "redirect:/signin";
		
	}

}

