package com.example.shop.order;


import java.io.Serializable;
import java.util.*;

import com.example.shop.model.OrderLine;

public class Cart implements Serializable{

	private ArrayList<OrderLine> cart = new ArrayList<OrderLine>();
	

	public ArrayList<OrderLine> getCart() {
		return cart;
	}

	public void setCart(ArrayList<OrderLine> cart) {
		this.cart = cart;
	}
	
	
}
