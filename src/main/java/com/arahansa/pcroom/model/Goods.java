package com.arahansa.pcroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="typeitem", length=50)
	private String typeItem;

	@Column(name="nameitem", length=100)
	private String nameItem;

	@Column(name="price")
	private int price;

	@Column(name="numitem")
	private int numItem;

	
	// Constructor 
	public Goods() {
	}
	
	public Goods(String typeItem, String nameItem, int price, int numItem) {
		super();
		this.typeItem = typeItem;
		this.nameItem = nameItem;
		this.price = price;
		this.numItem = numItem;
	}



	// Getter and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(String typeItem) {
		this.typeItem = typeItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumItem() {
		return numItem;
	}

	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}

}
