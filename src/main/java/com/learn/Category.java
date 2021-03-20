package com.learn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryTitle;
	private String categoryDiscreption;
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDiscreption() {
		return categoryDiscreption;
	}
	public void setCategoryDiscreption(String categoryDiscreption) {
		this.categoryDiscreption = categoryDiscreption;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category(String categoryTitle, String categoryDiscreption, List<Product> products) {
		super();
		this.categoryTitle = categoryTitle;
		this.categoryDiscreption = categoryDiscreption;
		this.products = products;
	}
	
	public Category(int id, String categoryTitle, String categoryDiscreption) {
		super();
		this.id = id;
		this.categoryTitle = categoryTitle;
		this.categoryDiscreption = categoryDiscreption;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryTitle=" + categoryTitle + ", categoryDiscreption="
				+ categoryDiscreption + "]";
	}
	

}
