package com.xavier.module.database.service;

import com.xavier.module.generate.domain.ConnectDb;
import org.springframework.jdbc.core.JdbcTemplate;

public interface DatabaseService {

  void switchConnect(ConnectDb connectDb);

  JdbcTemplate currentJdbcTemplate();
}
