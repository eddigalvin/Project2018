package com.example.shop.product;

import org.springframework.ui.Model;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shop.model.Product;
//import com.example.shop.productController.ProductRepository;
import java.util.*;

@Controller    
@RequestMapping(path="/product") 
public class ProductController {
	@Autowired 
	private ProductRepository productRepository;
	
		@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewProduct (@RequestParam String name
			, @RequestParam String description ,@RequestParam BigDecimal price , @RequestParam String cat, @RequestParam Integer stock) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Product p = new Product();
		p.setName(name);
		p.setDescription(description);
		p.setCat(cat);
		p.setStock(stock);
		p.setPrice(price);
		productRepository.save(p) ; 
		return "Saved";
	}
		
	
	//Angular View Api calls this Api.
	@GetMapping(path="/allang", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200")	
	public @ResponseBody Iterable<Product> getAllProduct() {
		return productRepository.findAll();
	}
				
		//Controller action uses Thymeleaf View Template Engine														
		@GetMapping(path="/all" , produces = "application/json")
		public ModelAndView getAllProducts() {
			ModelAndView mvw = new ModelAndView();
			mvw.setViewName("products"); 
			List<Product> prods=  (List<Product>) productRepository.findAll();
			  mvw.addObject("prods",prods);
			  return mvw;
		}							
		/*		
		@GetMapping(path="/all")
		public String getAllProducts(Model m) {
			// This returns a JSON or XML with the users
			List<Product> prods=  (ArrayList<Product>) productRepository.findAll();
			m.addAttribute("prods",prods); 
			  return "products";
			  //mvw.
		}								*/
	
	@GetMapping(path="/")
	public @ResponseBody Product getProduct(@RequestParam int id){
		
		return productRepository.findOne((Integer)id);
	}
	{
		
	}
	
}
