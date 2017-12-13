package com.cvs.digital.automation.specification;

import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.repository.FunctionalityTable;
import com.cvs.digital.automation.repository.ModuleTable;

public class FunctionalitiesByModuleIdSpecification implements SqlSpecification {

	private final int moduleId;

	public FunctionalitiesByModuleIdSpecification(final int moduleId) {
		this.moduleId = moduleId;
	}

	@Override
	public String toSqlQuery() {
		String sql = String.format("SELECT * FROM %1$s WHERE %2$s = %3$d;", FunctionalityTable.TABLE_NAME,ModuleTable.FIELD_MODULE_ID, moduleId);
		return sql;
	}
}
