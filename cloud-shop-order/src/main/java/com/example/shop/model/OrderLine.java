package com.example.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderLine")
public class OrderLine implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//@Column(name="order_Id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private long order_Id;
	private int product_Id;
	private String prodName;
	//private String prodDesc;
	private int quantity;
	private BigDecimal price;
	private BigDecimal subtotal;
    @ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name="orderId")//,nullable=false),updatable=false,insertable=false)
    //@JoinTable(name = "ORDER_ORDERLINE")
	//@JoinColumn(name="order_Id",updatable=false,insertable=false)
	Order order=new Order();
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLine )) return false;
        return (Integer)id != null && ((Integer)id).equals(((OrderLine) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
	//@ManyToOne
	//@JoinColumn(name = "productId" , referencedColumnName="product_Id")
	//private Product product;
	/**/
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}																



	public OrderLine() {}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/*
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}											*/
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	/*
	public long getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(long orderId) {
		this.order_Id = orderId;
	}													*/																																							
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

}
