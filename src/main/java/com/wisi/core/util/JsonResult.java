package com.wisi.core.util;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * return json object
 */
@Component
@Scope("prototype")
public class JsonResult {
	
	// 00：正常；01：错误；98：timeout；99：异常
	private String code = Constants.JSONRESULT_CODE_00;
	
	private Object success;

	private Object msg = null;

	private Object list = null;

	private Object total = null;
	
	private Object data = null;
	
	public JsonResult(){
		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public JsonResult(boolean success){
		this.success=success;
	}
	
	public JsonResult(boolean success, Object msg){
		if(!success)this.code = Constants.JSONRESULT_CODE_01;
		this.success=success;
		this.msg=msg;
	}
	
	public JsonResult(List<?> list){
		this.success = true;
		this.list = list;
	}
	
	public JsonResult(Map<?, ?> data){
		this.success = true;
		this.data = data;
	}
	
	public JsonResult(List<?> list, int total){
		this.success = true;
		this.list = list;
		this.total = total;
	}

	public Object getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
		if(!success)this.code = "0";
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public Object getTotal() {
		return total;
	}

	public void setTotal(Object total) {
		this.total = total;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	/**
	 * @param boo
	 * @return boo
	 */
	public JsonResult success(boolean boo){
		this.success = boo;
		return this;
	}

	/**
	 * 返回成功
	 * @param message
	 * @return
	 */
	public JsonResult success(){
		return this.success(true);
	}

	/**
	 * 返回失败
	 * @param message
	 * @return
	 */
	public JsonResult error(String message){
		this.msg = message;
		this.code = "0";
		return this.success(false);
	}
	/**
	 * 返回成功
	 * @param message
	 * @return
	 */
	public JsonResult success(String message){
		this.msg = message;
		return this.success();
	}
	/**
	 * 返回成功
	 * @param data
	 * @return
	 */
	public JsonResult success(Object data){
		this.data = data;
		return this.success();
	}
	
	/**
	 * 返回boo
	 * @param boo
	 * @param message
	 * @return
	 */
	public JsonResult success(boolean boo, String message){
		this.msg = message;
		this.success = boo;
		return this;
	}
}
