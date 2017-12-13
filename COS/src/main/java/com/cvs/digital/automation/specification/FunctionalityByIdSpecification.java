package com.cvs.digital.automation.specification;

import com.cvs.digital.automation.repository.FunctionalityTable;

public class FunctionalityByIdSpecification implements SqlSpecification {

	private final int moduleId;
	private final int id;

	public FunctionalityByIdSpecification(final int moduleId, final int id) {
		this.moduleId = moduleId;
		this.id = id;
	}

	@Override
	public String toSqlQuery() {
		String sql = String.format("SELECT * FROM %1$s WHERE %2$s = %3$d and %4$s = %5$d;", 
				FunctionalityTable.TABLE_NAME,
				FunctionalityTable.FEILD_FUNCTIONALITY_ID, 
				id,
				FunctionalityTable.FIELD_MODULE_ID,
				moduleId
				);
		return sql;
	}
}
