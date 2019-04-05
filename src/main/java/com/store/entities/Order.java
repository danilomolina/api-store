package com.store.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity order
 * @author Danilo Molina
 *
 */

@Entity
@Table(name = "order")
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String adress;
	private Date dateConfirmation;
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_order")
	private List<OrderItem> itens;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getDateConfirmation() {
		return dateConfirmation;
	}
	public void setDateConfirmation(Date dateConfirmation) {
		this.dateConfirmation = dateConfirmation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	

	public List<OrderItem> getItens() {
		return itens;
	}
	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", adress=" + adress + ", dateConfirmation=" + dateConfirmation + ", status="
				+ status + ", itens=" + itens + "]";
	}
	
	

}
