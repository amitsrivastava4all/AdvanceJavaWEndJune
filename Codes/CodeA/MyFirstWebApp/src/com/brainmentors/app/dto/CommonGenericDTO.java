package com.brainmentors.app.dto;

public class CommonGenericDTO {
	private String name;
	private String descr;
	
	public CommonGenericDTO(){}
	public CommonGenericDTO(String name, String descr){
		this.name = name;
		this.descr = descr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	

}
