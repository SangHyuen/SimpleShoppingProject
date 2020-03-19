package com.shopping01.domain;

import org.springframework.stereotype.Component;

@Component
public class productVO {
	private int productId;
	private String productName;
	private String productImg;
	private int cost;
	private int sailCost;
	private String basket;
	

	public String getBasket() {
		return basket;
	}
	public void setBasket(String basket) {
		this.basket = basket;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSailCost() {
		return sailCost;
	}
	public void setSailCost(int sailCost) {
		this.sailCost = sailCost;
	}
	
	@Override
	public String toString() {
		return "productVO [productId=" + productId + ", productName=" + productName + ", productImg=" + productImg
				+ ", cost=" + cost + ", sailCost=" + sailCost  + "]";
	}
	
}
