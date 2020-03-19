package com.shopping01.domain;

import org.springframework.stereotype.Component;

@Component
public class bannerVO {
	private int bannerId;
	private String coment;


	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int id) {
		this.bannerId = id;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	@Override
	public String toString() {
		return "bannerVO [bannerid=" + bannerId + ", coment=" + coment + "]";
	}

}
