package com.xavier.common.db;

import com.xavier.bean.db.model.Column;
import com.xavier.bean.db.model.Key;
import com.xavier.bean.db.model.Table;
import com.xavier.service.db.connection.util.TypeConverter;
import com.xavier.service.db.connection.util.TypeUtil;
import com.xavier.util.StringUtil;

import java.sql.*;


public class DefaultDatabase extends Database {

	private static final String COLUMN_NAME = "COLUMN_NAME";

	public static final String PKTABLE_NAME = "PKTABLE_NAME";
	public static final String PKCOLUMN_NAME = "PKCOLUMN_NAME";
	public static final String FKTABLE_NAME = "FKTABLE_NAME";
	public static final String FKCOLUMN_NAME = "FKCOLUMN_NAME";
	public static final String KEY_SEQ = "KEY_SEQ";

	public DefaultDatabase(Connection connection) {
		super(connection);
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see com.xavier.common.db.Database#getTable(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Table getTable(String catalog, String schema, String tableName) throws SQLException {
		ResultSet rs = null;
		Table table = null;
		String schemaPattern = null;
		try {
			if (StringUtil.isNotEmptyOrBlank(schema)) {
				schemaPattern = schema;
			}
			rs = connection.getMetaData().getTables(catalog, schemaPattern, tableName, new String[]{"TABLE", "VIEW"});
			if (rs.next()) {
				table = new Table();
				table.setCatalog(rs.getString("TABLE_CAT"));
				table.setSchema(rs.getString("TABLE_SCHEM"));
				table.setTableName(tableName);
				table.setRemarks(rs.getString("REMARKS"));
				table.setTableType(rs.getString("TABLE_TYPE"));

				introspectPrimaryKeys(table);
				introspectColumns(table);
				introspectForeignKeys(table);
				introspectExportedKeys(table);
				introspectIndex(table);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
		return table;
	}

	/**
	 * <p>获取表主键</p>
	 *
	 * @param table 表
	 * @throws SQLException
	 */
	protected void introspectPrimaryKeys(Table table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getPrimaryKeys(null, table.getSchema(), table.getTableName());
			while (rs.next()) {
				String columnName = rs.getString(COLUMN_NAME);
				Column column = table.getColumn(columnName);
				if (column == null) {
					column = new Column(columnName);
					table.addPrimaryKey(column);
				}
				column.setPrimaryKey(true);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	/**
	 * <p>获取表信息</p>
	 *
	 * @param table 表
	 * @throws SQLException
	 */
	protected void introspectColumns(Table table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getColumns(null, table.getSchema(), table.getTableName(), "%");
			while (rs.next()) {
				String columnName = rs.getString(COLUMN_NAME);
				if (StringUtil.isEmptyOrBlank(columnName)) {
					continue;
				}

				Column column = table.getColumn(columnName);
				if (column == null) {
					column = new Column(columnName);
					table.addBaseColumn(column);
				}
				column.setJdbcType(rs.getInt("DATA_TYPE"));
				column.setSize(rs.getInt("COLUMN_SIZE"));
				column.setNullable(rs.getInt("NULLABLE") == 1);
				column.setDefaultValue(rs.getString("COLUMN_DEF"));
				column.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
				column.setRemarks(rs.getString("REMARKS"));
				if (hasColumn(rs, "IS_AUTOINCREMENT")) {
					column.setAutoincrement(rs.getBoolean("IS_AUTOINCREMENT"));
				}

				column.setJdbcTypeName(TypeConverter.getTypeName(column.getJdbcType()));
				column.setJavaType(TypeUtil.calculateJavaType(column, false));
				column.setFullJavaType(TypeUtil.calculateJavaType(column, true));
				column.setJavaProperty(StringUtil.getCamelCaseString(columnName, false));
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	/**
	 * <p>获得外键的信息</p>
	 *
	 * @param table 表
	 * @throws SQLException
	 */
	protected void introspectForeignKeys(Table table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getImportedKeys(null, table.getSchema(), table.getTableName());
			while (rs.next()) {
				String columnName = rs.getString(FKCOLUMN_NAME);
				if (StringUtil.isEmptyOrBlank(columnName)) {
					continue;
				}

				Column column = table.getColumn(columnName);
				if (column != null) {
					column.setForeignKey(true);
				}
				String pkTableName = rs.getString(PKTABLE_NAME);
				String pkColumnName = rs.getString(PKCOLUMN_NAME);
				String fkTableName = rs.getString(FKTABLE_NAME);
				String fkColumnName = rs.getString(FKCOLUMN_NAME);
				String seq = rs.getString(KEY_SEQ);
				Integer iseq = new Integer(seq);
				table.addImportedKey(new Key(pkTableName, pkColumnName, fkTableName, fkColumnName, iseq));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	/**
	 * <p>获得外键的信息</p>
	 *
	 * @param table 表
	 * @throws SQLException
	 */
	protected void introspectExportedKeys(Table table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getExportedKeys(null, table.getSchema(), table.getTableName());
			while (rs.next()) {
				String columnName = rs.getString(FKCOLUMN_NAME);
				if (StringUtil.isEmptyOrBlank(columnName)) {
					continue;
				}
				String pkTableName = rs.getString(PKTABLE_NAME);
				String pkColumnName = rs.getString(PKCOLUMN_NAME);
				String fkTableName = rs.getString(FKTABLE_NAME);
				String fkColumnName = rs.getString(FKCOLUMN_NAME);
				String seq = rs.getString(KEY_SEQ);
				Integer iseq = new Integer(seq);
				table.addExportedKey(new Key(pkTableName, pkColumnName, fkTableName, fkColumnName, iseq));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	/**
	 * <p>获得索引</p>
	 *
	 * @param table 表
	 * @throws SQLException
	 */
	protected void introspectIndex(Table table) throws SQLException {
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getIndexInfo(null, table.getSchema(), table.getTableName(), true, true);
			while (rs.next()) {
				String columnName = rs.getString(COLUMN_NAME);
				if (StringUtil.isEmptyOrBlank(columnName)) {
					continue;
				}
				Column column = table.getColumn(columnName);
				if (column != null) {
					column.setUnique(!rs.getBoolean("NON_UNIQUE"));
					column.setIndexed(true);
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
		}
	}

	/**
	 * <p>查询表注释</p>
	 *
	 * @param table
	 * @param commentSql     查询表注释的SQL, 含一个占位符 (tableName)
	 * @param columnComments 注释列列名
	 * @throws SQLException
	 */
	protected void introspectTableComments(Table table, String commentSql, String columnComments) throws SQLException {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = connection.prepareStatement(commentSql);
			psmt.setString(1, table.getTableName());
			rs = psmt.executeQuery();
			if (rs.next()) {
				table.setRemarks(rs.getString(columnComments));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
			close(psmt);
		}
	}

	/**
	 * <p>查询表中列注释</p>
	 *
	 * @param table
	 * @param colCommentSql    查询表中列注释的SQL, 含一个占位符 (tableName)
	 * @param columnColumnName 字段名列列名
	 * @param columnComments   注释列列名
	 * @throws SQLException
	 */
	protected void introspectTableColumnsComments(Table table, String colCommentSql, String columnColumnName,
	                                              String columnComments) throws SQLException {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = connection.prepareStatement(colCommentSql);
			psmt.setString(1, table.getTableName());
			rs = psmt.executeQuery();
			while (rs.next()) {
				String columnName = rs.getString(columnColumnName);
				Column column = table.getColumn(columnName);
				if (column != null) {
					column.setRemarks(rs.getString(columnComments));
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			close(rs);
			close(psmt);
		}
	}

	/**
	 * <p>查询是否包含该列</p>
	 *
	 * @param rs         结果集
	 * @param columnName 列名
	 * @return
	 * @throws SQLException
	 */
	protected boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int x = 1; x <= columns; x++) {
			if (columnName.equals(rsmd.getColumnName(x))) {
				return true;
			}
		}
		return false;
	}
}
