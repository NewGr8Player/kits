package com.xavier.service.dbConnection;

import com.xavier.bean.dbConnection.DBConnection;

public interface DBConnectionService {

	/**
	 * <p>获取连接详情</p>
	 *
	 * @param dbConnection 连接属性详情
	 * @throws Exception
	 */
	void findConnectionDetails(DBConnection dbConnection);
}
