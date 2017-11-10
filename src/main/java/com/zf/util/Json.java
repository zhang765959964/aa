package com.zf.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class Json implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean success = true;
	
	private String msg = "";
	
	private List data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Json [success=" + success + ", msg=" + msg + ", data=" + data
				+ "]";
	}

	public Json(Boolean success, String msg, List data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
