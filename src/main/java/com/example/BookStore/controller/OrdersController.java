package com.example.BookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class OrdersController {

	@RequestMapping("/manageaddress")
	public String manageaddress(Model m)
	{
		m.addAttribute(m);
		return "/user/manageaddress";
	}
}
