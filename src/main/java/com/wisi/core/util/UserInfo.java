/*
 * UserInfo.java V1.0.0 Copyright WisiSoft LIMITED 2014.
 * system name（the underlying framework encapsulate）
 * 
 * service module（Session encapsulate）
 * 
 * Resume：
 *	No	Date			Ver			Update		Content
 *	1	2014/12/12		V1.0.0		xuxiaowei	create
 */
package com.wisi.core.util;

public class UserInfo {
	private int id;
	private String loginName;
	private String userName;
	private String password;
	private String true_name;
	
	private char sex;
	private String identity;
	private String birthday;
	private String tellPhone;
	private String mobilePhone;
	private int status;
	private String note;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * 所属机构ID（机构01、分支机构02、部门/科室03）
	 */
	private int org_id;
	
	/**
	 * 所属单位ID（机构01、分支机构02），如果是（部门/科室03）则会向上查找至（机构01、分支机构02）。
	 */
	private int true_org_id;
	/**
	 * 所属单位ID（机构01、分支机构02），如果是（部门/科室03）则会向上查找至（机构01、分支机构02）。
	 */
	public int getTrue_org_id() {
		return true_org_id;
	}
	/**
	 * 所属单位ID（机构01、分支机构02），如果是（部门/科室03）则会向上查找至（机构01、分支机构02）。
	 */
	public void setTrue_org_id(int true_org_id) {
		this.true_org_id = true_org_id;
	}
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTellPhone() {
		return tellPhone;
	}
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 所属机构ID（机构01、分支机构02、部门/科室03）
	 */
	public int getOrg_id() {
		return org_id;
	}
	/**
	 * 所属机构ID（机构01、分支机构02、部门/科室03）
	 */
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
}
