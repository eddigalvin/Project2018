package com.example.shop.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.example.shop.order.Cart;


import com.example.shop.model.Order;
import com.example.shop.model.OrderLine;
//import com.example.shop.productController.ProductRepository;
import com.example.shop.order.OrderRepository;

@Controller    
@RequestMapping(path="/order") 
public class OrderController {
	@Autowired 
private OrderRepository orderRepository;

@PostMapping(path="/add" ) // Map ONLY Post Requests
public @ResponseBody Order addNewOrder (@RequestParam int custId, @RequestBody Cart custCart) {

	Order o = new Order();	/**/
	o.setCustId(custId);
	ArrayList<OrderLine> lineItems = custCart.getCart();
	o.setLineItems(lineItems);
	int size = lineItems.size();
	BigDecimal total = BigDecimal.ZERO;
	for(int i = 0; i < size; i++) {
	 total= total.add(lineItems.get(i).getSubtotal());
	}
	o.setTotal(total);
	orderRepository.save(o) ;
	for(int i = 0; i < size; i++) {
		o.removeOrderLine( o.getLineItems().iterator().next());
	}
	return o;
	}									

@GetMapping(path="/all")
public @ResponseBody Iterable<Order> getAllOrders() {
// This returns a JSON or XML with the users
return orderRepository.findAll();
}										

}