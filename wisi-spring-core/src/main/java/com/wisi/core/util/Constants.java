/*
 * ComLogger.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（Logger encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants
 * 
 * @author xuxiaowei
 */
public class Constants {
	/** MySql DataBase */
	public final static String  mysql = "_mysql";
	/** Oracle DataBase */
	public final static String  oracle = "_oracle";
	
	public final static String  select = "_select";
	public final static String  count  = "_count";
	public final static String  insert = "_insert";
	public final static String  delete = "_delete";
	public final static String  update = "_update";
	
	/** catalog */
	public final static String PRIVTYPE_FOLDER = "01";
	/** right */
	public final static String PRIVTYPE_NODE = "02";
	
	/** User info session */
	public final static String USER_INFO_SESSION = "UserInfo";
	
	/** json return code. 00：正常 */
	public final static String JSONRESULT_CODE_00 = "00";
	
	/** json return code. 01：错误 */
	public final static String JSONRESULT_CODE_01 = "01";
	
	/** json return code. 98：timeout */
	public final static String JSONRESULT_CODE_98 = "98";
	
	/** json return code. 99：异常 */
	public final static String JSONRESULT_CODE_99 = "99";
	
	/**
	 * Get project path
	 * 
	 * @see com.wisi.core.spring.filter.SessionFilter.init()
	 */
	public static String getProjectPath(){
		return ProjectPath;
	}
	private static String ProjectPath;
	
	/**
	 * Get project URL
	 * 
	 * @see com.wisi.core.spring.filter.SessionFilter.init()
	 */
	public static String getProjectUrl(){
		return ProjectUrl;
	}
	private static String ProjectUrl;
	
	/**
	 * Get JS_Version
	 * 
	 * @see com.wisi.core.spring.filter.SessionFilter.init()
	 */
	public static String getJS_Version(){
		return JS_Version;
	}
	private static String JS_Version;
	
	/**
	 * Get database type
	 * 
	 * @see com.wisi.core.spring.filter.SessionFilter.init()
	 */
	public static String getDB_Type(){
		return DB_Type;
	}
	private static String DB_Type;
	
	/**
	 * Set system info
	 * 
	 * @param ProjectPath
	 * @param ProjectUrl
	 * @param JS_Version
	 * @param DB_Type
	 * 
	 * @see com.wisi.core.spring.filter.SessionFilter.init()
	 */
	public static void setSystemInfo(String ProjectPath, String ProjectUrl, String JS_Version, String DB_Type){
		Constants.ProjectPath = ProjectPath;
		Constants.ProjectUrl = ProjectUrl;
		Constants.JS_Version = JS_Version;
		Constants.DB_Type = DB_Type;
	}
	
	
	/** Map define */
	private static final Map<String, String> extMap;
	
	/**
	 * Get map
	 */
	public static final Map<String, String> getExtMap(){
		return extMap;
	}
	
	/**
	 * Set image flash media file
	 * 
	 * <pre>
	 * Constants.extMap.put("image", "gif,jpg,jpeg,png,bmp");
	 * Constants.extMap.put("flash", "swf,flv");
	 * Constants.extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
	 * Constants.extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	 * </pre>
	 */
	static {
		 Map<String, String> aMap = new HashMap<>(4);
		 aMap.put("image", "gif,jpg,jpeg,png,bmp");
		 aMap.put("flash", "swf,flv");
		 aMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		 aMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		 extMap = Collections.unmodifiableMap(aMap);
	}
	
	/** Upload path for original image */
	public static final String fileUploadImg_yt = "fileUpload/images/yt/";//上传原图
	
	/** Upload path for use image */
	public static final String fileUploadImg_xs = "fileUpload/images/xs/";//使用图片
	
	/** Upload path for abbreviations image */
	public static final String fileUploadImg_sl = "fileUpload/images/sl/";//缩略图
	
	/** Upload path for temp image */
	public static final String fileUploadImg_temp = "fileUpload/temp/";//临时路径
	
	/** Upload path for page */
	public static final String fileUploadImg_ymtp = "fileUpload/ymtp/";//页面图片路径

	public static final String p = "/";
	
	public static final int  sl_height = 60;
	public static final int sl_width = 60;

	public static final int img_height = 500;
	public static final int img_width = 800;
	
	/** Upload path */
	public static final String fileUpload_Excel = "fileUpload/Excel/";
}
