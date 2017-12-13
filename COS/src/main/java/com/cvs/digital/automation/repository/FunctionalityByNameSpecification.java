package com.cvs.digital.automation.repository;

import com.cvs.digital.automation.specification.SqlSpecification;

public class FunctionalityByNameSpecification implements SqlSpecification {

	private final int id;

	public FunctionalityByNameSpecification(final int id) {
		this.id = id;
	}

	@Override
	public String toSqlQuery() {
		return String.format("SELECT * FROM %1$s WHERE `%2$s` = %3$d';", ModuleTable.TABLE_NAME,
				ModuleTable.FIELD_MODULE_ID, id);
	}
}
