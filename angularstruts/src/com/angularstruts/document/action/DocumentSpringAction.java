package com.angularstruts.document.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.angularstruts.document.bo.DocumentBo;

@Component
public class DocumentSpringAction {

	@Autowired
	@Qualifier("documentBo")
	private DocumentBo studentBo;
	private String name;

	
	public String execute() {

		studentBo.printStudent();
		name = "ali";
		return "success";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DocumentBo getStudentBo() {
		return studentBo;
	}

	public void setStudentBo(DocumentBo studentBo) {
		this.studentBo = studentBo;
	}

}
