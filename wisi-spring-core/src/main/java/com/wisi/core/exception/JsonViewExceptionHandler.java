/*
 * JsonViewExceptionHandler.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（JsonViewExceptionHandler encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.view.json.JsonExceptionHandler;

import com.wisi.core.logger.ComLogger;

/**
 * JsonViewExceptionHandler
 * 
 * @author xuxiaowei
 */
public class JsonViewExceptionHandler implements JsonExceptionHandler {
	/** Logger define */
	private static final Logger logger = ComLogger.getInstance();
	
	/**
     * Construction method
     * 
     * @param message exception
     * @param model
     * @param request
     * @param response
     */
	@Override
	public void triggerException(Exception exception, Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Print error log message
		logger.error(exception.getMessage(), exception);
		
		if (exception instanceof BaseException) {
			model.put("msg", exception.getMessage());
			return;
		}

		String msg = "111";
		if (exception instanceof DataIntegrityViolationException) {
			
			String error = exception.getCause().toString();
			if (error.contains("ORA-02292")) {
				msg = "请先删除子数据。";
			} else if (error.contains("ORA-00001")) {
				msg = "数据已存在，请检查。";
			}
			
		} else if (exception instanceof MaxUploadSizeExceededException) {
			msg = "文件大小超过上限。";
		}

		model.put("msg", msg);
	}
}
