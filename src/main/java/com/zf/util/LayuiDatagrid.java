package com.zf.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * layui 表格操作
 * 
 * @author Administrator
 * 
 */
public class LayuiDatagrid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code = 0;

	private String msg = "";

	private Long count;

	private List data = new ArrayList();

	public LayuiDatagrid(Integer code, String msg, Long count, List data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public LayuiDatagrid() {
		super();
	}
}
