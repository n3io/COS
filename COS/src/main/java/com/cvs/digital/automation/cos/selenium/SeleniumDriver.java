package com.cvs.digital.automation.cos.selenium;

import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.repository.AccessRepository;
import com.cvs.digital.automation.repository.Repository;

public class SeleniumDriver {

	public void execute() {
		String accessDbFilePath = "C:/Users/kalidass/git/COS/COS/cos.accdb";
	
		Repository or = new AccessRepository(accessDbFilePath);
		Module module =  or.getModule("Login");
		System.out.println(module.getModuleName());
	}
}
