package com.xavier.service.dbInfo;

import com.xavier.bean.dbInfo.DBInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DBInfoServiceImpl implements DBInfoService {

    private static final Log LOGGER = LogFactory.getLog(DBInfoService.class);

    @Override
    public void getConnectionDetails(DBInfo dbInfo) {
        LOGGER.info(dbInfo);
    }
}
