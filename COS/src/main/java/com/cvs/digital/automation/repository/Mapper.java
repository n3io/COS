package com.cvs.digital.automation.repository;

public interface Mapper<From, To> {
	To map(From from);

}
