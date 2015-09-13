/*
 * BaseException.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（BaseException encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.exception;

/**
 * BaseException
 * 
 * @author xuxiaowei
 */
public class BaseException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Construction method
     * 
     * @param message Exception message
     */
	public BaseException(String message) {
		super(message);
	}
	
	/**
     * Construction method
     */
	public BaseException() {
		super();
	}
	
}
