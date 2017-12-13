package com.cvs.digital.automation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cvs.digital.automation.entity.Entity;

public interface Mapper {
	Entity map(ResultSet  from)throws SQLException;

}
