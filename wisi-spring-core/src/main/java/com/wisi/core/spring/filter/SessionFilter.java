/*
 * SessionFilter.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（Filter encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wisi.core.logger.ComLogger;
import com.wisi.core.util.Constants;
import com.wisi.core.util.UserInfo;

/**
 * Session Filter
 * 
 * @author xuxiaowei
 */
public class SessionFilter implements Filter {
	/** Logger define */
	private static final Logger logger = ComLogger.getInstance();
	
	/**
     * Init session filter
     *
     * @param filterConfig A filter configuration object used by a servlet container
	 * to pass information to a filter during initialization.
     */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化系统信息
		Constants.setSystemInfo(
			filterConfig.getServletContext().getRealPath(""),
			filterConfig.getServletContext().getContextPath(),
			filterConfig.getInitParameter("JS_Version"),
			null);
	}
	
	/**
     * Do session filter
     *
     * @param request HttpServletRequest
     * @param response ServletResponse
     * @param chain A FilterChain is an object provided by the servlet container to the developer
     * giving a view into the invocation chain of a filtered request for a resource. Filters
     * use the FilterChain to invoke the next filter in the chain, or if the calling filter
     * is the last filter in the chain, to invoke the resource at the end of the chain.
     */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Instance HttpServletRequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// Get submit URL
		String url = httpServletRequest.getRequestURI();
		
		// Print URL
		if(logger.isDebugEnabled()){
			logger.log(ComLogger.DEBUG, url);
		}
		
		// 过滤/page/ 路径.jsp|.html
		if(url.matches("^(\\w|\\W)*\\.(jsp|html)$")){
			
			HttpSession session = httpServletRequest.getSession();
			UserInfo userInfo = (UserInfo) session.getAttribute(Constants.USER_INFO_SESSION);
			
			if (userInfo == null || "".equals(userInfo)) {
				session.invalidate();
				
				if(logger.isDebugEnabled()){
					logger.log(ComLogger.DEBUG, "SESSION过期,url:" + url);
				}
				
				if(url.matches("^.+(/page/|/main\\.html).*$")){
					
					String QueryString = httpServletRequest.getQueryString();
					if("hash=".equals(QueryString)||QueryString==null||"".equals(QueryString)){
						QueryString = "";
					}else{
						QueryString = "?"+QueryString;
					}
					httpServletRequest.setAttribute("url", url.substring(Constants.getProjectUrl().length()+1)+QueryString);
					httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
					
				}else{
					HttpServletResponse newResponse = (HttpServletResponse) response;
					newResponse.setHeader("sessiontimeout", "1");
//					newResponse.setStatus(998);
					newResponse.setContentType("text/plain;charset=UTF-8");
					newResponse.getWriter().write("{success:false,msg:\"您的登陆信息已过期，请先登录。\"}");
				}
				
				return;
			}
		}
		chain.doFilter(httpServletRequest, response);
		
	}
	
	/**
     * Destroy session filter
     */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
