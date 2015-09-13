package com.wisi.core.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	public void setHttpServletRequestAndResponse(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.session = request.getSession();
		this.response = response;
	}
}