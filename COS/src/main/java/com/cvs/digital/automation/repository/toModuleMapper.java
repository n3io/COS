package com.cvs.digital.automation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cvs.digital.automation.entity.Entity;
import com.cvs.digital.automation.entity.Module;

public class toModuleMapper implements Mapper {

	
	@Override
	public Entity map(ResultSet rset) throws SQLException {
		
		int rowCount = 0;
		Module module = new Module();
		module.setModuleID(rset.getInt(ModuleTable.FIELD_MODULE_ID));
		module.setModuleName(rset.getString(ModuleTable.FIELD_MODULE_NAME));
		return module;
	}

	
}
