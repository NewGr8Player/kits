package com.xavier.service.dbInfo;

import com.xavier.bean.dbInfo.DBInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBInfoServiceImpl implements DBInfoService {

	private static final Log LOGGER = LogFactory.getLog(DBInfoService.class);

	@Override
	public void getConnectionDetails(DBInfo dbInfo) {
		LOGGER.info(dbInfo);

		test();
	}

	public static void test() {
		String driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/restful";
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		String sql = "select * from user";
		try {
			Class.forName(driver);
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("Cant't load Driver");
		}
		try {
			con = DriverManager.getConnection(URL, "root", "root");
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int countcols = rsmd.getColumnCount();
				for (int i = 1; i <= countcols; i++) {
					if (i > 1) System.out.print(";");
					System.out.print(rsmd.getColumnName(i) + " ");
				}
				System.out.println("");
				while (rs.next()) {
					System.out.print(rs.getString("id") + "  ");
					System.out.print(rs.getString("username") + "  ");
					System.out.print(rs.getString("nickname") + "  ");
					System.out.print(rs.getString("password") + "  ");
				}
			}
			System.out.println("ok");
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Connect fail:" + e.getMessage());
		}
	}
}
