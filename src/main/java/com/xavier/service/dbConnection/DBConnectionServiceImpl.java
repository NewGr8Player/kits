package com.xavier.service.dbConnection;

import com.xavier.bean.dbConnection.DBConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionServiceImpl implements DBConnectionService {

	private static final Log LOGGER = LogFactory.getLog(DBConnectionServiceImpl.class);

	@Override
	public void findConnectionDetails(DBConnection dbConnection) {
		LOGGER.info(dbConnection);
	}
}
