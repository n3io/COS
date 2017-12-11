package com.cvs.digital.automation.entity;

import java.util.List;

public class BusinessElement implements Entity {
	private int businessElementID;
	private String elementByID;
	private String elementByName;
	private String elementByClassName;
	private String elementByTagName;
	private String elementByLinkText;
	private String elementByPartialLinkText;
	private String elementByXpath;
	private Element element;
	private List<BusinessAction> businessAction;
}
