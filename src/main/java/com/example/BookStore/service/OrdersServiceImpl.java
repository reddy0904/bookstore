package com.example.BookStore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.Address;
import com.example.BookStore.entity.Cart;
import com.example.BookStore.entity.Customer_details;
import com.example.BookStore.entity.OrderDetails;
import com.example.BookStore.entity.Orders;
import com.example.BookStore.repository.AddressRepository;
import com.example.BookStore.repository.CartRepository;
import com.example.BookStore.repository.OrderDetailsRepository;
import com.example.BookStore.repository.OrdersRepository;
@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private OrdersRepository ordersRepo;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public void saveOrder(int addressId, String totalprice, String discount, String shippingcost, String grandtotal,
			String paymentmethod) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();
        Customer_details loggedInUser = customerService.getUserByUsername(loggedInUsername);
        Address address=addressRepo.findById(addressId);
        String status="Order Placed";
        LocalDateTime currentDateTime = LocalDateTime.now();
		Orders order=new Orders(loggedInUser,address,status,totalprice,discount,shippingcost,grandtotal,currentDateTime,paymentmethod);
		ordersRepo.save(order);
		List<Cart> c= cartRepo.findByUserId(loggedInUser.getId());
		for(Cart i:c) {
			
			OrderDetails d=new OrderDetails(loggedInUser,order,i.getAllBook(),i.getQuantity(),i.getAllBook().getPrice()*i.getQuantity());
			orderDetailsRepo.save(d);
			cartRepo.deleteById(i.getId());
			
		}
	}

}
