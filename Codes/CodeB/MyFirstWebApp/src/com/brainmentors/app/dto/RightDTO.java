package com.brainmentors.app.dto;

public class RightDTO {
	private String name;
	private String screenName;
	public RightDTO(String name, String screenName){
			this.name  = name;
			this.screenName = screenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	

}
