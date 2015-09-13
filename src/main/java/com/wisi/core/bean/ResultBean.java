package com.wisi.core.bean;

public class ResultBean {
	private Integer retcode;
	private String errormsg;
	
	public ResultBean(){
		this.retcode = 0;
		errormsg = "success";
	}
	
	public int getRetcode() {
		return retcode;
	}
	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[ResultBean:");
		
		if(retcode != null){
			sb.append("retcode=").append(retcode).append(".");
		}
		if(errormsg != null || errormsg.trim().equals("")){
			sb.append("retcode=").append(retcode).append(".");
		}
		return sb.toString();
	}
}
