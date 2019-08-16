package com.example.web.utils;

import com.alibaba.fastjson.JSONObject;

public class Result {

	private int status = 10001 ;
	private String msg = "success" ;
	private JSONObject data = new JSONObject() ;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
}
