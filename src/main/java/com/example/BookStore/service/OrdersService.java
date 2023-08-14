package com.example.BookStore.service;

public interface OrdersService {
	public void saveOrder(int addressId,String totalprice,String discount,String shippingcost,String grandtotal,String paymentmethod);
}
