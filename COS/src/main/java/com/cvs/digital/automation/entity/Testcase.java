package com.cvs.digital.automation.entity;

import java.util.List;

public class Testcase implements Entity {
	private int testcaseID;
	private String testcaseName;
	private List<Teststep> testSteps;
}
