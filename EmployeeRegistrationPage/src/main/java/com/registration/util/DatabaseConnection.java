package com.registration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	/**
	 * This method is used for database connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return connection
	*/
	public Connection databaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DatabaseConstant.DRIVER);
		Connection connection = DriverManager.getConnection(DatabaseConstant.URL_PATH, DatabaseConstant.USER_NAME, DatabaseConstant.PASSWORD);
		return connection;
	}

}