/*
 * SessionListener.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（SessionListener encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.spring.listener;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.wisi.core.logger.ComLogger;
import com.wisi.core.util.UserInfo;

/**
 * Session Listener
 * 
 * @author xuxiaowei
 */
public class SessionListener implements HttpSessionListener {
	/** Logger define */
	private static final Logger logger = ComLogger.getInstance();
	
	/** Save session user info */
	private static Map<String, UserInfo> userMap = new Hashtable<>();
	
	/** Count login user */
	private static int count = 0;
	
	/**
     * Create session
     *
     * @param HttpSessionEvent
     */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Destroy session
     *
     * @param HttpSessionEvent
     */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();
		
		if(userMap.get(sessionId)!=null){
			userMap.remove(sessionId);
			count--;
		}
		if(logger.isDebugEnabled()){
			logger.log(ComLogger.DEBUG, "【SESSION】过期：" + sessionId);
		}
		
		//UserService userService = (UserService) SpringContextUtil.getBean("userService");
		//userService.sessionDestroyed(null, sessionId);
	}
	
	/**
     * Get user info
     *
     * @param sessionId
     */
	public static UserInfo getUserForUserMap(String sessionId){
		return userMap.get(sessionId);
	}
	
	/**
	 * Add user info
	 * 
	 * @param sessionId
	 * @param userInfo
	 */
	public static void addSession(String sessionId, UserInfo userInfo){
		if(userMap.get(sessionId) == null){
			count++;
		}
		userMap.put(sessionId, userInfo);
	}
	
	/**
	 * Get user count
	 */
	public static int getCount(){
		return count;
	}
}
