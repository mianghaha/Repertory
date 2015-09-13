package com.wisi.core.spring.interceptor;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wisi.core.logger.ComLogger;
import com.wisi.core.util.Constants;
import com.wisi.core.util.JsonResult;
import com.wisi.core.util.UserInfo;

public class WisiSessionInterceptor extends HandlerInterceptorAdapter {
	/** Logger define */
	private static final Logger logger = ComLogger.getInstance();
	
	/** The json name of the request header: "accept". */
	private static final String REQUEST_HEADER_KEY_01 = "accept";
	
	/** The json name of the request header: "X-Requested-With". */
	private static final String REQUEST_HEADER_KEY_02 = "X-Requested-With";
	
	/** The json name of the request header value: "application/json". */
	private static final String REQUEST_HEADER_VALUE_01 = "application/json";
	
	/** The json name of the request header value: "X-Requested-With". */
	private static final String REQUEST_HEADER_VALUE_02 = "XMLHttpRequest";
	
	private Properties sessionMappings;
	
	private String timeoutView;
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		// session
		HttpSession session;
		// user info
		UserInfo userInfo;
		
		// Get submit URL
		String url = request.getRequestURI();
		
		// Print URL
		if(logger.isDebugEnabled()){
			logger.log(ComLogger.DEBUG, url);
		}
		
		// if is not check return true.
		if(isNotCheckSession(sessionMappings, url)){
			return true;
		}
		
		// get user info of session.
		session = request.getSession();
		userInfo = (UserInfo) session.getAttribute(Constants.USER_INFO_SESSION);
		
		// if user info is not null return true.
		if(userInfo != null && !"".equals(userInfo.getLoginName())){
			return true;
		}
		
		// print url address.
		if(logger.isDebugEnabled()){
			logger.log(ComLogger.DEBUG, "【SESSION过期】【URL】：" + url);
		}
		
		if(isJsonRequest(request)){
			// if request is json return json data.
			PrintWriter writer = response.getWriter();
			JsonResult json = new JsonResult();
			
			json.setSuccess(false);
			json.setCode(Constants.JSONRESULT_CODE_98);
			json.setMsg("长时间未操作页面，请重新登录页面！");
			writer.write(JSONObject.fromObject(json).toString());
			writer.flush();
		}else{
			response.sendRedirect(request.getContextPath() + timeoutView);
		}
		return false;
	}
	
	/**
	 * Set the mappings between session class names.
	 * @param mappings session patterns as keys.
	 */
	public void setSessionMappings(Properties mappings) {
		this.sessionMappings = mappings;
	}
	
	/**
	 * Find a session check url.
	 * @param sessionMappings mappings between session check url.
	 * @return is not session check
	 * @see #setSessionMappings
	 */
	protected boolean isNotCheckSession(Properties sessionMappings, String url) {
		for (Enumeration<?> names = sessionMappings.propertyNames(); names.hasMoreElements();) {
			String sessionMapping = (String) names.nextElement();
			// if is not check return true.
			if(url.indexOf(sessionMapping) > -1){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Is json request
	 * 
	 * @return is json request return true else return false
	 */
	private boolean isJsonRequest(HttpServletRequest request) {
		if(request.getHeader(REQUEST_HEADER_KEY_01).indexOf(REQUEST_HEADER_VALUE_01) > -1
				|| (request.getHeader(REQUEST_HEADER_KEY_02) != null
				&& request.getHeader(REQUEST_HEADER_KEY_02).indexOf(REQUEST_HEADER_VALUE_02) > -1)){
			// is json request
			return true;
		}else{
			// is not json request
			return false;
		}
	}
	
	/**
	 * Set the name of the default timeout view.
	 * This view will be returned if no specific mapping was found.
	 * <p>Default is none.
	 */
	public void setTimeoutView(String timeoutView) {
		this.timeoutView = timeoutView;
	}
}
