package com.example.BookStore.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			session.setAttribute("msg1", "Verify Your email by clicking on link sent to the registered mail");
		}
		}
		return "redirect:/signin";
		
	}
	
	@GetMapping("/verify")
	public String verifyAccount(@Param("code") String code) {
		
		if(customerService.verifyAccount(code)) {
			return "verifySuccess";
		}
		else {
			return "failed";
		}
		
	}

	@GetMapping("/forgotPassword")
	public String loadForgotPassword() {
		return "forgotPassword";
	}

	
	@PostMapping("/forgotPsw")
	public String forgotPassword(String email, HttpSession session) {
		if(customerService.checkEmail(email)) {
			customerService.sendChangePasswordMail(email);
			session.setAttribute("msg1", "Please click on link sent to your mail");
			return "redirect:/forgotPassword";
		}
		else {
			session.setAttribute("msg1", "invalid email address");
			return "forgotPassword";
		}
				
	}
	
	@GetMapping("/reset/{id}")
	public String resetPassword(@PathVariable("id") int Id, Model m) {
		m.addAttribute("userid", Id);
		return "resetPassword";
	}
	
	@PostMapping("/reset")
	public String passwordChange(int id, String psw) {
		customerService.changePassword(id, psw);
		return "redirect:/";
	}

}

