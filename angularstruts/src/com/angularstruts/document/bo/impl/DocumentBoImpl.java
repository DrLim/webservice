package com.angularstruts.document.bo.impl;


import org.springframework.stereotype.Component;

import com.angularstruts.document.bo.DocumentBo;


@Component("documentBo")
public class DocumentBoImpl implements DocumentBo {

	private Long id;
	private String name;

	
	
	public DocumentBoImpl() {
		super();
	}


	public DocumentBoImpl(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public void printStudent() {
		System.out.println("printUser() is executed...");

	}
	
	@Override
	public String toString() {
		return this.id+":"+this.name;
	}

}
