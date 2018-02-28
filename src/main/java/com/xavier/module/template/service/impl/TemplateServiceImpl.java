package com.xavier.module.template.service.impl;

import com.alibaba.fastjson.JSON;
import com.xavier.module.template.bean.TemplateDetails;
import com.xavier.module.template.service.TemplateService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Override
	public List<TemplateDetails> getAllTemplates() {
		File file = new File(TEMPLATE_PATH);
		if (!file.exists()) {
			file.mkdirs();
		}

		List<TemplateDetails> templateDetails = new ArrayList<>();
		try {
			File[] templateDirs = file.listFiles(File::isDirectory); /* 模板目录 */
			for (File templateDir : templateDirs) {

				String templateDirName = templateDir.getName();
				File configFile = new File(templateDir, "config.json");

				/* 读文件时即指定文件编码，避免因编码问题导致字符乱码 */
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
				String s;
				StringBuffer json_context = new StringBuffer();
				while ((s = bufferedReader.readLine()) != null) {/* 使用readLine方法，一次读一行 */
					json_context.append(System.lineSeparator() + s);
				}
				bufferedReader.close();

				TemplateDetails details = JSON.parseObject(json_context.toString(), TemplateDetails.class);
				details.setPath(templateDirName);
				templateDetails.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return templateDetails;
	}

}
