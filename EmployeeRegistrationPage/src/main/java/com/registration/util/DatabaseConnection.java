package com.registration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection extends DatabaseConstant {

	/**
	 * This method is used for database connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return connection
	*/
	public Connection databaseConnection() throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL_PATH, USER_NAME, PASSWORD);
		return connection;
	}

}