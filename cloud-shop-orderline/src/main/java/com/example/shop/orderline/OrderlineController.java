package com.example.shop.orderline;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.shop.model.Order;
import com.example.shop.model.OrderLine;
import com.example.shop.model.Product;


@Controller   
@RequestMapping(path="/orderline") 
public class OrderlineController {
	@Autowired 
	private OrderlineRepository orderlineRepository;
	private static HashMap<Integer,Cart> cartList ;
	
	
		@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody ArrayList<OrderLine> addNewOrderLine (
			@RequestParam int custId ,
			@RequestParam int productId ,			 
			@RequestParam int quantity  )   
			{
		OrderLine ol = new OrderLine();
		RestTemplate restTemplate = new RestTemplate();
		Product prod = restTemplate.getForObject("http://localhost:8080/product/?id="+productId,Product.class);
		ol.setProduct_Id(productId);
		ol.setProdName(prod.getName());
		//ol.setProdDesc(prodDesc);
		ol.setPrice(prod.getPrice());
		ol.setQuantity(quantity);
		ol.setSubtotal(ol.getPrice().multiply(BigDecimal.valueOf(quantity)));
		//If no cartList exists create a cartList 
		if(cartList==null) {
			cartList=new HashMap<Integer,Cart>();
		}
		//if cust has no cart, create a cart , else add to existing cart
		if(cartList.get(custId)==null) {
			Cart newCart = new Cart();
			newCart.getCart().add(ol);
			cartList.put(custId, newCart);
		}
		else {
			cartList.get(custId).getCart().add(ol);
		}					
		
		return cartList.get(custId).getCart();			//"Saved";
	}									
		
	@PostMapping(path="/order/")
	public @ResponseBody Order/*String*/ createOrder(@RequestParam int custId) {
		Cart custCart=cartList.get(custId);
		RestTemplate restTemplate = new RestTemplate();
		Order o = restTemplate.postForObject("http://localhost:8090/order/add/?custId="+custId,custCart,Order.class);				
		cartList.remove(custId);
		return o;					
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<OrderLine> getAllOrderLines() {
		return orderlineRepository.findAll();
	}
	
	@GetMapping(path="/")
	public @ResponseBody OrderLine getOrderLine(@RequestParam int id){
		
		return orderlineRepository.findOne((Integer)id);
	}
	{
		
	}
	
}
