package com.cvs.digital.automation.repository;

import com.cvs.digital.automation.entity.Module;

public interface Repository {

	Module getModule(final int moduleID);
	Module getModule(final String moduleName);
}
