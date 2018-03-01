package com.xavier.module.database.service;


import com.xavier.module.database.entity.mysql.Schemata;
import com.xavier.module.database.entity.mysql.Tables;
import com.xavier.module.database.entity.mysql.Columns;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 数据库辅助类
 */
public interface MySqlService {
    /**
     * 获取所有Schemata
     *
     * @return
     */
    List<Schemata> getAllSchemata();

    /**
     * 获取指定schemata所有Table
     *
     * @param schemata 指定schemata
     * @return
     */
    List<Tables> getAllSchemataTables(String schemata);

    /**
     * 获取指定schemata 所有 columns
     *
     * @param schemata 指定schemata
     * @return
     */
    List<Columns> getAllSchemataColumns(String schemata);

    /**
     * 获取指定schemata下指定指定table 所有 columns
     *
     * @param schemata 指定schemata
     * @param table    指定table
     * @return
     */
    List<Columns> getAllSchemataTableColumns(String schemata, String table);

    /**
     * 获取指定table下指定指定table 所有 columns
     *
     * @param table 指定table
     * @return
     */
    List<Columns> getAllSchemataTableColumns(Tables table);

    void switchJdbcTemplate(JdbcTemplate jdbcTemplate);
}
