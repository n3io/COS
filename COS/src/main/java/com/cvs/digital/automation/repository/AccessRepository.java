package com.cvs.digital.automation.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cvs.digital.automation.entity.Module;
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

}
