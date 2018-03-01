package com.xavier.module.generate.service;


import com.xavier.module.database.bean.GenerateData;

/**
 * 代码生成Service
 */
public interface MySqlGenerateService {

	/**
	 * <p>生成代码</p>
	 *
	 * @param generateData 生成的数据信息
	 * @throws Exception
	 */
	void generate(GenerateData generateData) throws Exception;
}
