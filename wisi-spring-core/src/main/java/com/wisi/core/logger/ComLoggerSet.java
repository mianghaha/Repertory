/*
 * ComLoggerSet.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（Logger encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Logger properties set
 * 
 * @author xuxiaowei
 */
public class ComLoggerSet {
	/** Logger object */
	private Logger logger = null;
	
	/** Logger properties */
	private ComLoggerProperties property = new ComLoggerProperties();
	
	/**
	 * Construction method
	 * 
	 * @param name Logger name
	 * 
	 * @author xuxiaowei
	 */
	public ComLoggerSet(String name) {
		// Init Logger
		this.init(name);
		
		// Set logger properties
		PropertyConfigurator.configure(this.property.getProperties());
		
		// Get logger name
		this.logger = Logger.getLogger(name);
	}
	
	/**
	 * Get instance logger
	 * 
	 * @author xuxiaowei
	 */
	public Logger getInstance() {
		
		return logger;
	}

	/**
	 * Init logger properties
	 * 
	 * @param name Logger name
	 * 
	 * @author xuxiaowei
	 */
	public void init(String name) {
	   property.setAppend("true");
	   property.setLogName(name);
	   property.setStdout("org.apache.log4j.ConsoleAppender");
	   property.setStdoutLayout("org.apache.log4j.PatternLayout");
	   property.setLayoutPattern("%d{yyyy/MM/dd HH:mm:ss,SSS} %l%m%n");
	   property.setDailyRolling("org.apache.log4j.DailyRollingFileAppender");
	   property.setDataPattern("'.'yyyy/MM/dd");
	   property.setFile("Lomos_" + name + ".log");
	   //property.setFileSize("1MB");
	   //property.setMaxBackUp("5");
	   property.setLayout("org.apache.log4j.PatternLayout");
	   property.setConversionPattern("%d{yyyy/MM/dd HH:mm:ss:SSS}: %l%m%n");
	   
	   //property.setLogType("org.apache.log4j.RollingFileAppender");
	   //property.setLogType("org.apache.log4j.DailyRollingFileAppender");
	   //property.setThreShold("debug");
	}
}
