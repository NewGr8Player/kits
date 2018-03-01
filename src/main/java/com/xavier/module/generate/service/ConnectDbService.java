package com.xavier.module.generate.service;

import com.xavier.module.generate.domain.ConnectDb;

import java.util.List;

public interface ConnectDbService {

    void save(ConnectDb connectDb);

    List<ConnectDb> findAll();

    void deleteById(String id);
}
