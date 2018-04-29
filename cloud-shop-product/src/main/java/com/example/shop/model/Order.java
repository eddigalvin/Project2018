package com.example.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//import com.example.shop.model.OrderLine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name="orders")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int custId;
	//@OneToMany(cascade = CascadeType.ALL,  mappedBy = "order_Id" /* mappedBy="order" */ , fetch = FetchType.EAGER)
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="order_irderid",
					joinColumns= {@JoinColumn(name="orderId")},
					inverseJoinColumns= @JoinColumn(name="order_Id"))			*/
	@OneToMany(cascade = CascadeType.ALL,mappedBy=/*"order_Id"*/"order",fetch = FetchType.LAZY, orphanRemoval = true)
	//@JoinColumn(name="order_Id")
	//@JsonProperty("order")
	private Collection<OrderLine> lineItems = new ArrayList<OrderLine>();
	
	private BigDecimal total;
	//private Payment payment;
	
	public Order() {}
	/*	*/
	public void addOrderLine(OrderLine orderline) {
		lineItems.add(orderline);
		orderline.setOrder(this);
	}
	
	public void removeOrderLine(OrderLine orderline) {
		lineItems.remove(orderline);
		orderline.setOrder(null);
	}																		
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;					
	}
	public Collection<OrderLine> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<OrderLine> lineItems) {
		this.lineItems = lineItems;	
		for(OrderLine orderline:lineItems) {
			orderline.setOrder(this);
			
		}
	}
		public void setNullLineItems() {
				
			for(OrderLine orderline:this.lineItems) {
				orderline.setOrder(null);
				
			}
	}																													
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}										/**/
	

}
