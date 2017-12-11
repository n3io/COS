package com.cvs.digital.automation.repository;

import java.util.List;

import com.cvs.digital.automation.entity.Module;
import com.cvs.digital.automation.specification.Specification;

public interface Repository<T> {

	Module getModule(int moduleID);
	List<T> query(Specification specification);
}
