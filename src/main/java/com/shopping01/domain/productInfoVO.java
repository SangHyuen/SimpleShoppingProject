package com.shopping01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class productInfoVO {
	
	private int productId;
	private String productName;
	private String productImg;
	private String coment;
	
	@JsonIgnore
	private int infoNum;
	
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
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public int getInfoNum() {
		return infoNum;
	}
	public void setInfoNum(int infoNum) {
		this.infoNum = infoNum;
	}
	
	@Override
	public String toString() {
		return "productInfoVO [productId=" + productId + ", productName=" + productName + ", productImg=" + productImg
				+ ", coment=" + coment + ", infoNum=" + infoNum + "]";
	}

	
	
}
