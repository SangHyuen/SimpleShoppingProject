package com.shopping01.domain;

import org.springframework.stereotype.Component;

@Component
public class returnVO {
	private Object data;
	private String code;
	private String message;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "returnVO [data=" + data + ", code=" + code + ", message=" + message + "]";
	}
	
	
	
}
