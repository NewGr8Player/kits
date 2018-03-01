package com.xavier.module.generate.service.impl;

import com.xavier.module.generate.dao.ConnectDbRepository;
import com.xavier.module.generate.domain.ConnectDb;
import com.xavier.module.generate.service.ConnectDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectDbServiceImpl implements ConnectDbService {

	@Autowired
	private ConnectDbRepository connectDbRepository;

	@Override
	public void save(ConnectDb connectDb) {
		connectDbRepository.save(connectDb);
	}

	@Override
	public List<ConnectDb> findAll() {
		return this.connectDbRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		connectDbRepository.delete(id);
	}
}
