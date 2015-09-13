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
package com.wisi.core.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * ComLogger
 * 
 * @author xuxiaowei
 */
public class ComLogger {
    /** Logger define */
    private static Logger logger = null;

    /** DEBUG */
    public static final Level DEBUG = Level.DEBUG;

    /** INFO */
    public static final Level INFO = Level.INFO;

    /** FATAL */
    public static final Level FATAL = Level.FATAL;

    /** WARN */
    public static final Level WARN = Level.WARN;

    /** ERROR */
    public static final Level ERROR = Level.ERROR;
    
    /**
	 * Construction method
	 */
    private ComLogger(){
    	
    }
    
    /**
     * Get Logger instance
     *
     * @return Logger
     */
    public static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger("wisi");

        }

        return logger;
    }
    
    /**
     * Get Logger instance
     * 
     * @param logName Logger file name
     *
     * @return Logger
     */
    public static Logger getInstance(String logName) {
    	ComLoggerSet logSet = new ComLoggerSet(logName);
    	
    	logger = logSet.getInstance();

        return logger;
    }
    
    /**
     * Logger out print
     *
     * @param level Logger level
     * @param obj Logger message
     */
    public static void log(Level level, Object obj) {
        logger.log(level, obj);
    }

    /**
     * Exception out pring
     *
     * @param cause Throwable
     *
     * @return exception message
     */
    public static String logException(Throwable cause) {
    	StringBuffer view = new StringBuffer();
        
		StackTraceElement st[];
		String temp = "";
		int k = 0;
		boolean nativeFlag = false;
		final String NATIVEMETHOD = "Native Method";
		final String TAB          = "\t";
		final String AT           = "at ";
		final String LEFT_KAKKO   = "(";
		final String RIGHT_KAKKO  = ")";
		final String COLON        = ":";
		final String DOT          = ".";
		final String LINEFEED     = System.getProperty("line.separator");

		// exception
		st = cause.getStackTrace();
		// 
		temp = LINEFEED + cause.toString() + LINEFEED;
		// buffer to set
		view.append(temp);
		temp = "";
		while(k < st.length){
			nativeFlag = st[k].isNativeMethod();
			// 
			if(nativeFlag){
				temp = TAB + AT + st[k].getClassName() + DOT + st[k].getMethodName() + LEFT_KAKKO
						+ NATIVEMETHOD + RIGHT_KAKKO + LINEFEED;
			}else{
				temp = TAB + AT + st[k].getClassName() + DOT + st[k].getMethodName() + LEFT_KAKKO
				        + st[k].getFileName() + COLON + st[k].getLineNumber() + RIGHT_KAKKO + LINEFEED;
			}
			// buffer to set
			view.append(temp);
			k++;
		}
        return view.toString();
    }
}
