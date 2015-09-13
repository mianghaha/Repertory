/*
 * ComLoggerProperties.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（Logger encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/13		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.logger;

import java.util.Properties;

/**
 * Logger properties set
 * 
 * @author xuxiaowei
 * 
 * @date 2014/12/13 15:25
 */
public class ComLoggerProperties {
	
	private final String LOG = "log4j.appender.logs";
	
	private final String LOG_NAME = "log4j.logger.";
	
	private final String LOG_STDOUT = "log4j.appender.stdout";
	
	private final String LOG_STDOUT_LAYOUT = "log4j.appender.stdout.layout";
	
	private final String LOG_LAYOUT_PATTERN = "log4j.appender.stdout.layout.ConversionPattern";
	
	private final String LOG_DAILY_ROLLYING = "log4j.appender.R";
	
	private final String LOG_FILE = "log4j.appender.R.file";
	
	private final String LOG_DATA_PATTERN = "log4j.appender.R.DatePattern";
	
	private final String LOG_LAYOUT = "log4j.appender.R.layout";
	
	private final String LOG_CONVERSION_PATTERN = "log4j.appender.R.layout.ConversionPattern";
	
	private final String LOG_THRESHOLD = "log4j.appender.logs.Threshold";
	
	private final String LOG_IMMEDIATEFLUSH = "log4j.appender.logs.ImmediateFlush";
	
	private final String LOG_DATEPATTERN = "log4j.appender.logs.DatePattern";
	
	private final String LOG_MAXFILESIZE = "log4j.appender.logs.MaxFileSize";
	
	private final String LOG_MAXBACKUPINDEX = "log4j.appender.logs.MaxBackupIndex";
	
	private final String LOG_APPEND = "log4j.appender.logs.Append";
	
	private Properties props = null;
	
	private String basePath = "D:/";

	/**
	 * Construction method
	 * 
	 * @author xuxiaowei
	 */
	public ComLoggerProperties() {
	   props = new Properties();
	   props.put("log4j.rootLogger","debug");
	}

	/**
	 * Logger name set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger name
	 */
	public void setLogName(String value) {
	   props.put(this.LOG_NAME + value, "debug, stdout, R");
	}
	
	/**
	 * Logger stdout set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger stdout
	 */
	public void setStdout(String value) {
	   props.put(this.LOG_STDOUT, value);
	}
	
	/**
	 * Logger stdout layout set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger stdout layout
	 */
	public void setStdoutLayout(String value) {
	   props.put(this.LOG_STDOUT_LAYOUT, value);
	}
	
	/**
	 * Logger layout pattern set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger layout pattern
	 */
	public void setLayoutPattern(String value) {
	   props.put(this.LOG_LAYOUT_PATTERN, value);
	}
	
	/**
	 * Logger daily rolling set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger daily rolling
	 */
	public void setDailyRolling(String value) {
	   props.put(this.LOG_DAILY_ROLLYING, value);
	}
	
	/**
	 * Logger data pattern set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger data pattern
	 */
	public void setDataPattern(String value) {
	   props.put(this.LOG_DATA_PATTERN, value);
	}
	
	/**
	 * Logger conversion pattern set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger conversion pattern
	 */
	public void setConversionPattern(String value) {
	   props.put(this.LOG_CONVERSION_PATTERN, value);
	}
	
	/**
	 * Logger type set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger type
	 */
	public void setLogType(String value) {
	   props.put(this.LOG, value);
	}

	/**
	 * Logger file path set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger file path
	 */
	public void setFile(String value) {
	   props.put(this.LOG_FILE, basePath + value);
	}
	
	/**
	 * Logger append set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger append
	 */
	public void setAppend(String value) {
	   props.put(this.LOG_APPEND, value);
	}
	
	/**
	 * Logger file size set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger file size
	 */
	public void setFileSize(String value) {
	   props.put(this.LOG_MAXFILESIZE, value);
	}
	
	/**
	 * Logger backup set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger backup
	 */
	public void setMaxBackUp(String value) {
	   props.put(this.LOG_MAXBACKUPINDEX, value);
	}
	
	/**
	 * Logger immediate flush set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger immediate flush
	 */
	public void setImmediateFlush(String value) {
	   props.put(this.LOG_IMMEDIATEFLUSH, value);
	}
	
	/**
	 * Logger layout set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger layout
	 */
	public void setLayout(String value) {
	   props.put(this.LOG_LAYOUT, value);
	}
	
	/**
	 * Logger date pattern set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger date pattern
	 */
	public void setDatePattern(String value) {
	   props.put(this.LOG_DATEPATTERN, value);
	}
	
	/**
	 * Logger threshold set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger threshold
	 */
	public void setThreShold(String value) {
	   props.put(this.LOG_THRESHOLD, value);
	}
	
	/**
	 * Logger progerties get
	 * 
	 * @author xuxiaowei
	 */
	public Properties getProperties() {
	   return props;
	}
	
	/**
	 * Logger path get
	 * 
	 * @author xuxiaowei
	 */
	public String getBasePath() {
	   return basePath;
	}
	
	/**
	 * Logger path set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger path
	 */
	public void setBaseRoot(String basePath) {
	   this.basePath = basePath;
	}
	
	/**
	 * Logger properties set
	 * 
	 * @author xuxiaowei
	 * 
	 * @param value logger properties
	 */
	public void setProps(Properties props) {
	   this.props = props;
	}
}
