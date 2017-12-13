package com.cvs.digital.automation.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cvs.digital.automation.entity.Entity;
import com.cvs.digital.automation.specification.Specification;
import com.cvs.digital.automation.specification.SqlSpecification;

public class AccessQuery implements Query{

	public static List<Entity> query(Connection con, SqlSpecification specification, Mapper mapper) {
		List<Entity> mylist  = new ArrayList<Entity>();
		// Connection con;
		Statement st;
		ResultSet rset;

		try {
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// con =
			// DriverManager.getConnection("jdbc:ucanaccess://c:///temp//Books2010.accdb");
			st = con.createStatement();
			rset = st.executeQuery(specification.toSqlQuery());
			while(rset.next()) {   // Move the cursor to the next row
				mylist.add(mapper.map(rset));
	         }
			System.out.println("success");

		} catch (Exception e) {
			System.out.println(e);

		}
		return mylist;
	}
}
