package com.shopping01.domain;

import org.springframework.stereotype.Component;

@Component
public class userVO {
	
	private int userId;
	private String name;
	private String email;
	private String password;
	private String passwordCheck;
	private String birth;
	private String gender;
	
	
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth.substring(0, 10);
	}
	@Override
	public String toString() {
		return "userVO [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", birth=" + birth + ", gender=" + gender + "]";
	}
	

}
