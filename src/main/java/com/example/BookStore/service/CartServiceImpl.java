package com.example.BookStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookStore.entity.Cart;
import com.example.BookStore.entity.Customer_details;
import com.example.BookStore.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartRepository cartRepo;

	@Override
	public List<Cart> getBooksForLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUsername = authentication.getName();
		Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
		return cartRepo.findByUserId(loggedInUser.getId());

	}

	@Override
	public void save(Cart book) {
		cartRepo.save(book);
	}
	
	@Override
    public void deleteById(int Id) {
        cartRepo.deleteById(Id);
    }
}
