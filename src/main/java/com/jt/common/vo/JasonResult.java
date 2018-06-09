package com.jt.common.vo;

import java.io.Serializable;

public class JasonResult implements Serializable {

	private static final long serialVersionUID = -5599198139665626265L;
	private static final int SUCCESS = 1;
	private static final int ERROR = 0;
	private int state=1;//1表示ok,0表示error
	private String message;
	private Object data;
	
	public JasonResult(String message) {
		this.message = message;
	}
	
	public JasonResult(Object data) {
		this.data = data;
	}
	
	public JasonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
