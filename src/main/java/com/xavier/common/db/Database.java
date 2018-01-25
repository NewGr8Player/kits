package com.xavier.common.db;

import com.xavier.bean.db.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>数据库连接模型抽象类</p>
 *
 * @author NewGr8Player
 */
public abstract class Database {

	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

	protected Connection connection;

	public Database(Connection connection) {
		this.connection = connection;
	}

	/**
	 * <p>获得表模型</p>
	 *
	 * @param catalog   Catalog
	 * @param schema    Schema
	 * @param tableName 表名
	 * @return
	 * @throws SQLException
	 */
	public abstract Table getTable(String catalog, String schema, String tableName) throws SQLException;

	public Connection getConnection() {
		return connection;
	}

	/**
	 * <p>关闭ResultSet</p>
	 *
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			LOGGER.info(e.getMessage(), e);
		}
	}

	/**
	 * <p>关闭Statement</p>
	 *
	 * @param statement
	 */
	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			LOGGER.info(e.getMessage(), e);
		}
	}
}
