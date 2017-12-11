package com.cvs.digital.automation.repository;

import java.util.List;

import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.specification.Specification;
import com.cvs.digital.automation.specification.SqlSpecification;

public class ModuleAccessRepository implements Repository<Module> {

	@Override
	public Module getModule(int moduleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> query(Specification specification) {
		final SqlSpecification sqlSpecification = (SqlSpecification) specification;

		final SQLiteDatabase database = openHelper.getReadableDatabase();
		final List<News> newses = new ArrayList<>();

		try {
			final Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery(), new String[] {});

			for (int i = 0, size = cursor.getCount(); i < size; i++) {
				cursor.moveToPosition(i);

				newses.add(toModuleMapper.map(cursor));
				
			}

			cursor.close();

			return newses;
		} finally {
			database.close();
		}
	}

}
