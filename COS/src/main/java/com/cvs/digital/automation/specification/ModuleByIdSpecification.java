package com.cvs.digital.automation.specification;

import com.cvs.digital.automation.repository.ModuleTable;

public class ModuleByIdSpecification implements SqlSpecification {

	private final int id;

    public ModuleByIdSpecification(final int id) {
        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        String sql = String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = %3$d';",
                ModuleTable.TABLE_NAME,
                ModuleTable.FIELD_MODULE_ID,
                id
        );
        return sql;
    }
}
