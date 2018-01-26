package com.xavier.service.db.connection;

import com.xavier.bean.db.info.DBInfo;
import com.xavier.common.db.impl.MySqlDatabase;
import com.xavier.service.db.connection.util.TypeConverter;

import java.sql.*;

/**
 * <p>测试用</p>
 *
 * @Author NewGr8Player
 */
public class AnalysisDatabaseStructure {

	private Connection connection = null;

	public static final String TABLE_SCHEM = "TABLE_SCHEM";
	public static final String TABLE_NAME = "TABLE_NAME";
	public static final String TABLE_TYPE = "TABLE_TYPE";
	public static final String TYPE_CAT = "TYPE_CAT";
	public static final String REMARKS = "REMARKS";
	public static final String TABLE_CAT = "TABLE_CAT";
	public static final String TYPE_SCHEM = "TYPE_SCHEM";
	public static final String TYPE_NAME = "TYPE_NAME";
	public static final String SELF_REFERENCING_COL_NAME = "SELF_REFERENCING_COL_NAME";
	public static final String REF_GENERATION = "REF_GENERATION";

	public AnalysisDatabaseStructure(DBInfo dbInfo) {
		try {
			Class.forName(dbInfo.getDriver()).newInstance();
			connection = java.sql.DriverManager.getConnection(dbInfo.getConnectURL(), dbInfo.getUsername(), dbInfo.getPassword());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getTblResultSet() {
		ResultSet tblResultSet = null;
		try {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			return dbMetaData.getTables(null, null, null, new String[]{"TABLE", "VIEW"});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tblResultSet;
	}


	public void getTblDetail(String tblName) {
		StringBuffer sbCloumns = new StringBuffer();
		String sql = "select * from " + tblName;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int columeCount = meta.getColumnCount();
			sbCloumns.append("表 " + tblName + "共有 " + columeCount + " 个字段。字段信息如下：\n");
			for (int i = 1; i < columeCount + 1; i++) {
				sbCloumns.append("字段名：" + meta.getColumnName(i) + "\n");
				sbCloumns.append("类型：" + TypeConverter.getTypeName(meta.getColumnType(i)) + "\n");
				sbCloumns.append("------------------------------\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(sbCloumns.toString());
	}

	public void destroy() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) throws SQLException {

		String connectURL = "jdbc:mysql://127.0.0.1:3306/restful?useUnicode=true&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=round&autoReconnect=true&useSSL=true";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";

		DBInfo dbInfo = new DBInfo("test01", connectURL, driver, username, password);

		AnalysisDatabaseStructure analysisDatabaseStructure = new AnalysisDatabaseStructure(dbInfo);

		MySqlDatabase db = new MySqlDatabase(analysisDatabaseStructure.getConnection());

		System.out.println(db.getTable(null, null, "user"));
	}
}
