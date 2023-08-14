package com.example.BookStore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BookStore.entity.Address;
import com.example.BookStore.entity.Cart;
import com.example.BookStore.entity.Customer_details;
import com.example.BookStore.service.AddressService;
import com.example.BookStore.service.CartService;
import com.example.BookStore.service.CustomerService;
import com.example.BookStore.service.OrdersService;


@Controller
@RequestMapping("/user")
public class OrdersController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;

	@RequestMapping("/orderplaced")
	public String orderplaced()
	{
		
		return "/user/demo";
	}
	
	@PostMapping("/orderplaced")
	public String order(@RequestParam(name="selectedAddress",required = false) Integer id,
			@RequestParam("totalprice") String totalprice,
			String discount,
			@RequestParam("shipcost")String shippingcost,String grandtotal,HttpSession session,String paymentMethod)
	{
		if(id==null)
		{
			session.setAttribute("msg","Please Add Appropriate Address");
			return "redirect:/user/orders";
		}
		else {
			int a=id.intValue();
			ordersService.saveOrder(a,totalprice,discount, shippingcost, grandtotal,paymentMethod);
	        return "/user/demo";
		}
	}
	
	@RequestMapping("/orders")
    public String orders(Model m)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
    	List<Cart> list = cartService.getBooksForLoggedInUser();
    	m.addAttribute("item",list);
    	List<Address> ad=addressService.allSavedAddress(loggedInUser.getId());
    	m.addAttribute("savedAddresses",ad);
    	return "/user/orders";
    }
}

