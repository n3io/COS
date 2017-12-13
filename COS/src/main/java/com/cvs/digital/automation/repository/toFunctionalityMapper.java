package com.cvs.digital.automation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cvs.digital.automation.entity.Entity;
import com.cvs.digital.automation.entity.Functionality;
import com.cvs.digital.automation.entity.Module;

public class toFunctionalityMapper implements Mapper {

	
	@Override
	public Entity map(ResultSet rset) throws SQLException {
		Functionality functionality = new Functionality();
		functionality.setModuleID(rset.getInt(ModuleTable.FIELD_MODULE_ID));
		functionality.setFunctionalityID(rset.getInt(FunctionalityTable.FEILD_FUNCTIONALITY_ID));
		functionality.setFunctionalityName(rset.getString(FunctionalityTable.FIELD_FUNCTIONALITY_NAME));
		return functionality;
	}


	
}
