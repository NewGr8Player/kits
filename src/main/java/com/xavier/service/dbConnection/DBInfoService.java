package com.xavier.service.dbConnection;

import com.xavier.bean.dbInfo.DBInfo;

/**
 * <p>数据库信息Service</p>
 */
public interface DBInfoService {

    /**
     * <p>获取连接信息</p>
     *
     * @param dbInfo 数据连接信息Bean
     */
    void getConnectionDetails(DBInfo dbInfo);
}
