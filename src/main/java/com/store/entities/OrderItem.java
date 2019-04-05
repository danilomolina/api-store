package com.store.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity orderItem
 * @author Danilo Molina
 *
 */

@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String description;
	private Double unitPrice;
	private int quantity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", description=" + description + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + "]";
	}
	
	

}
