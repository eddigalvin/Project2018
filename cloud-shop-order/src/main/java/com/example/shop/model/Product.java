package com.example.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.math.BigDecimal;

import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@XmlRootElement
//@Table(name="Product")
public class Product {
	

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer product_Id;
	    private String name;
	    private String description;
	    private String cat;
	    private Integer stock;
	    private BigDecimal price;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product_Id", fetch = FetchType.EAGER)
	    private List<OrderLine> lineItems;// = new ArrayList<OrderLine>();
	    
	    public Product() {}
	    
	    public Integer getProduct_Id() {
			return product_Id;
		}
		public void setId(Integer product_Id) {
			this.product_Id = product_Id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCat() {
			return cat;
		}
		public void setCat(String cat) {
			this.cat = cat;
		}
			public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		public BigDecimal getPrice() {
			return price;
		}								
		
		public void setPrice(BigDecimal price) {
			this.price = price;
		}															
		
		
		
		

}
