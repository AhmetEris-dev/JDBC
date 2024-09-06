package com.ahmete._01_JDBC_Eticaret.repository;

import com.ahmete._01_JDBC_Eticaret.utility.Constants;

import static com.ahmete._01_JDBC_Eticaret.utility.Constants.*;

import java.sql.*;

public class DatabaseHelper {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private boolean openConnection(){
		try {
			DriverManager.getConnection("jdbc:postgresql://"+ DB_HOSTNAME+":"+DB_PORT+"/"+DB_NAME, DB_USERNAME,DB_PASSWORD);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Bağlantı Hatası.... "+e.getMessage());
			return false;
		}
	}
}