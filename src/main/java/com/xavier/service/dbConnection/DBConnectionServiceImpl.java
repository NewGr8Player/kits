package com.xavier.service.dbConnection;

import com.xavier.bean.dbConnection.DBConnection;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionServiceImpl implements DBConnectionService {

	@Override
	public void findConnectionDetails(DBConnection dbConnection) {
		System.out.println(dbConnection);
	}
}
