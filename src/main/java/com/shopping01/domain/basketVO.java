package com.shopping01.domain;

import org.springframework.stereotype.Component;

@Component
public class basketVO {
	
	private int userId;
	private int productId;
	private String productName;
	private String productImg;
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "basketVO [userId=" + userId + ", productId=" + productId + "]";
	}
	

}
