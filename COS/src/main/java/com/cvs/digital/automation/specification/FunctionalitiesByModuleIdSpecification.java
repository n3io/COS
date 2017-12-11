package com.cvs.digital.automation.specification;

public class FunctionalitiesByModuleIdSpecification implements SqlSpecification {

	private final int id;

    public FunctionalitiesByModuleIdSpecification(final int id) {
        this.id = id;
    }

    @Override
    public String toSqlQuery() {
        /*return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = %3$d';",
                NewsTable.TABLE_NAME,
                NewsTable.Fields.ID,
                id
        );*/
    	return null;
    }
}
