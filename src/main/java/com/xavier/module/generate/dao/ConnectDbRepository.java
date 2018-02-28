package com.xavier.module.generate.dao;

import com.xavier.module.generate.domain.ConnectDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectDbRepository extends JpaRepository<ConnectDb,String> {
}
