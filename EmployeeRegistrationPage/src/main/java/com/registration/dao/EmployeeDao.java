package com.registration.dao;

import com.registration.model.Employee;

/*This interface is used for declare methods signature*/
public interface EmployeeDao {

	public boolean saveRegistration(Employee employee);

	public boolean isMobileNumberExists(String contactNumber);

}