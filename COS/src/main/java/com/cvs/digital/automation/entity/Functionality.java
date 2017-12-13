package com.cvs.digital.automation.entity;

import java.util.List;

public class Functionality implements Entity {
	private int moduleID;
	private int functionalityID;
	private String functionalityName;
	private List<Testcase> testcases;
	

	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public int getFunctionalityID() {
		return functionalityID;
	}

	public void setFunctionalityID(int functionalityID) {
		this.functionalityID = functionalityID;
	}

	public String getFunctionalityName() {
		return functionalityName;
	}

	public void setFunctionalityName(String functionalityName) {
		this.functionalityName = functionalityName;
	}

	public List<Testcase> getTestcases() {
		return testcases;
	}

	public void setTestcases(List<Testcase> testcases) {
		this.testcases = testcases;
	}
}


	
