package com.cognizant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private String product;
	private int price;
	private String category;
	private int port;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Menu( String product, int price, String category) {
		
		this.product = product;
		this.price = price;
		this.category = category;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", product=" + product + ", price=" + price + ", category=" + category + ", port="
				+ port + "]";
	}

}
