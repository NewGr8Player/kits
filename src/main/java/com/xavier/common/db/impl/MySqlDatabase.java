package com.xavier.common.db.impl;

import com.xavier.bean.db.model.Table;
import com.xavier.common.db.DefaultDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDatabase extends DefaultDatabase {

	private static final String TABLE_COMMENTS_SQL  = "show table status where NAME=?";

	public MySqlDatabase(Connection connection){
		super(connection);
	}

	@Override
	public Table getTable(String catalog, String schema, String tableName) throws SQLException {
		Table table = super.getTable(catalog, schema, tableName);
		if (table != null) {
			introspectTableComments(table, TABLE_COMMENTS_SQL, "COMMENT");
		}
		return table;
	}

}
