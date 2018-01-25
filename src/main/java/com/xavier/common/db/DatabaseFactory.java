package com.xavier.common.db;

import com.xavier.common.db.impl.MySqlDatabase;
import com.xavier.service.db.connection.util.TypeUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseFactory {

	private DatabaseFactory() {

	}

	/**
	 * <p>获得数据库连接对象</p>
	 *
	 * @param connection 连接
	 * @return
	 * @throws SQLException
	 */
	public static Database createDatabase(Connection connection) throws SQLException {
		String dbProduct = connection.getMetaData().getDatabaseProductName();
		Database database;
		switch (dbProduct) {
			case TypeUtil.MYSQL:
				database = new MySqlDatabase(connection);
				break;
			default:
				database = new DefaultDatabase(connection);
		}
		return database;
	}
}
