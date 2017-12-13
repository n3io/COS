package com.cvs.digital.automation.specification;

import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.repository.FunctionalityTable;
import com.cvs.digital.automation.repository.ModuleTable;

public class FunctionalityByNameSpecification implements SqlSpecification {

	private final Module module;
	private final String functionalityName;
	
	public FunctionalityByNameSpecification(final Module module, final String functionalityName) {
		this.module = module;
		this.functionalityName = functionalityName;
	}

	@Override
	public String toSqlQuery() {
		String sql = String.format("SELECT * FROM %1$s WHERE %2$s = '%3$s' and %4$s = '%5$s';",
				FunctionalityTable.TABLE_NAME, FunctionalityTable.FIELD_FUNCTIONALITY_NAME, functionalityName,
				ModuleTable.FIELD_MODULE_NAME, module.getModuleName());
		return sql;
	}
}
