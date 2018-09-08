package com.brainmentors.actions;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport{ //implements Action {
	private ArrayList<String> country = new ArrayList<>();
	private String message;
	private String co;
	private String userid;
	private String pwd;
	
	@Override
	public void validate() {
		if(userid!= null && userid.trim().length()==0) {
			addFieldError("userid", getText("error.userblank"));
		}
		if(pwd!=null && pwd.trim().length()==0) {
			addFieldError("pwd", getText("error.pwdblank"));
		}
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String dologin() {
		return null;
	}
	
	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public ArrayList<String> getCountry() {
		return country;
	}

	public void setCountry(ArrayList<String> country) {
		this.country = country;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	private void prepareData() {
		//country = new ArrayList<>();
		country.add("India");
		country.add("USA");
		country.add("UK");
		
	}
	public String loadlogin() {
		this.prepareData();
		System.out.println("List is "+country);
		message = "Login Page";
		return "login";
	}
	
	public String sayHello() {
		 setMessage("Hello I am Struts");
		return "success";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(this.getUserid().equals(this.getPwd())) {
			message  = "Login SuccessFully";
			return SUCCESS;
		}
		else {
			message="Invalid Userid or Password";
			return ERROR;
		}
		//return null;
	}
	
}
