package com.cvs.digital.automation.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvs.digital.automation.entity.Entity;
import com.cvs.digital.automation.entity.Functionality;
import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.entity.Testcase;
import com.cvs.digital.automation.specification.FunctionalitiesByModuleIdSpecification;
import com.cvs.digital.automation.specification.ModuleByNameSpecification;
import com.cvs.digital.automation.specification.Specification;
import com.cvs.digital.automation.specification.SqlSpecification;

public class AccessRepository implements Repository {
	Connection con;
	
	public AccessRepository(String accessDbFilePath){
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://"+accessDbFilePath);
			//con = DriverManager.getConnection("jdbc:ucanaccess://c:///temp//Books2010.accdb");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Module getModule(int moduleID) {

		SqlSpecification specification = new ModuleByIdSpecification(moduleID);
		Mapper mapper = new toModuleMapper();
		AccessQuery.query(con, specification, mapper);
		return (Module)AccessQuery.query(con, specification, mapper).get(0);
	}
	
	@Override
	public Module getModule(String moduleName) {

		SqlSpecification specification = new ModuleByNameSpecification(moduleName);
		Mapper mapper = new toModuleMapper();
		AccessQuery.query(con, specification, mapper);
		Module module = (Module)AccessQuery.query(con, specification, mapper).get(0);
		module.setFunctionalities(getFunctionalities(module));
		return module;
	}

	private List<Functionality> getFunctionalities(Module module) {
		SqlSpecification specification = new FunctionalitiesByModuleIdSpecification(module.getModuleID());
		Mapper mapper = new toFunctionalityMapper();
		List<Functionality> functionalities =  (List<Functionality>)(List<?>)AccessQuery.query(con, specification, mapper);
		functionalities.forEach( item -> item.setTestcases(getTestcases(item)));
		return functionalities;
	}

	private List<Testcase> getTestcases(Functionality functionality) {
		SqlSpecification specification = new FunctionalitiesByModuleIdSpecification(functionality.getFunctionalityID());
		Mapper mapper = new toTestcaseMapper();
		List<Testcase> testcases =  (List<Testcase>)(List<?>)AccessQuery.query(con, specification, mapper);
		testcases.forEach( item -> item.setTestcases(getTeststeps(item)));
		return testcases;
	}

	private Object getTeststeps(Testcase testcase) {
		SqlSpecification specification = new FunctionalitiesByModuleIdSpecification(testcase.getFunctionalityID());
		Mapper mapper = new toTestcaseMapper();
		List<Testcase> testcases =  (List<Testcase>)(List<?>)AccessQuery.query(con, specification, mapper);
		testcases.forEach( item -> item.setTestcases(getTeststeps(item)));
		return testcases;

}
