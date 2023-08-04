package com.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.registration.model.Employee;
import com.registration.util.DatabaseConnection;

/*This class is used for define methods body*/
public class EmployeeDaoImpl implements EmployeeDao {

	private PreparedStatement preparedStatement;
	private Connection connection;
	DatabaseConnection connect = new DatabaseConnection();

	/**
	 * This methods is used for save registration details
	 * @param employee object which contain firstName,lastName,userName,password,address,contact value
	 * @return result true/false
	*/
	@Override
	public boolean saveRegistration(Employee employee) {
		try {
			connection = connect.databaseConnection();
			String query = "INSERT INTO registration (first_name, last_name, username, password, address, contact) VALUES (?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUserName());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			int result = preparedStatement.executeUpdate();
			connection.close();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This methods is used for check duplicate contact number
	 * @param contactNumber
	 * @return result true/false
	*/
	@Override
	public boolean isMobileNumberExists(String contactNumber) {
		try {
			connection = connect.databaseConnection();
			String query = "SELECT contact FROM registration WHERE contact = '" + contactNumber + "'";
			preparedStatement = connection.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}