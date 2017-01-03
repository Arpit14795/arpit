package com.util;

import java.sql.Connection;

public interface ConnectionManager {
	public Connection getConnection();

	public void closeConnection();
}
