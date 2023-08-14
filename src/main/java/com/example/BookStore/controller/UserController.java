package com.example.BookStore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.entity.Address;
import com.example.BookStore.entity.Cart;
import com.example.BookStore.entity.Customer_details;
import com.example.BookStore.repository.CartRepository;
import com.example.BookStore.repository.CustomerRepository;
import com.example.BookStore.service.AddressService;
import com.example.BookStore.service.CartService;
import com.example.BookStore.service.CustomerService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CustomerRepository userRepo;
	

	@GetMapping("/availablebooks")
	public String availablebooks() {
		return "user/availablebooks";
	}

	@GetMapping("/mybooks")
    public ModelAndView getAllBooks(){
        List<Cart> list = cartService.getBooksForLoggedInUser();
        ModelAndView m = new ModelAndView();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
        boolean recordsPresent = cartService.isCartEmpty(loggedInUser.getId());
        m.setViewName("/user/mybooks");
        m.addObject("cart", list);
        m.addObject("recordsPresent",recordsPresent);
        return m;
	}
	@RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int Id){
        cartService.deleteById(Id);
        return "redirect:/user/mybooks";
    }
	@GetMapping("/profile")
	public String profile(Model m)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
        Customer_details cd=customerService.getUserById(loggedInUser.getId());
        
    	m.addAttribute("customer_name",cd.getFullname());
    	m.addAttribute("customer_email",cd.getEmail());
    	m.addAttribute("customer_phoneno",cd.getPhoneno());
		return "/user/profile";
	}
	@PostMapping("/profile")
	public String updateprofile(String fullname,String email,String phoneno,String password) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
		if(customerService.checkPassword(loggedInUser.getId(),password)) {
			customerService.updateProfile(loggedInUser.getId(), fullname, email, phoneno);
		}
		else {
			System.out.println("Byeeee");
		}
		return "redirect:/user/profile";
	}
	
	@RequestMapping("/incrementQuantity/{cartItemId}")
    public String incrementQuantity(@PathVariable int cartItemId) {
        Cart cartItem = cartRepo.findById(cartItemId);
        if (cartItem != null) {
            cartService.incrementQuantity(cartItem);
        }
        return "redirect:/user/mybooks"; // Redirect to cart page
    }

    @RequestMapping("/decrementQuantity/{cartItemId}")
    public String decrementQuantity(@PathVariable int cartItemId) {
        Cart cartItem = cartRepo.findById(cartItemId);
        if (cartItem != null) {
            cartService.decrementQuantity(cartItem);
        }
        return "redirect:/user/mybooks";
    }
    
    
    
}
