package com.xavier.module.database.bean;

import com.xavier.module.database.entity.mysql.Tables;
import com.xavier.module.template.bean.TemplateDetails;
import com.xavier.module.template.bean.TemplateFtl;

public class GenerateData {
	private String author = "";/* 作者 */

	private String url = "";

	private String basePath;/* 代码生成的根路径 */

	private String basePackage;/* 基本的包 */

	private TemplateDetails templateDetails;/* 模板详情 */

	private TemplateFtl template;/* 模板 */

	private String domainName;/* 实体类名称 */

	private String templatePath;/* 模板路径 */

	private Tables table;/* 表 */

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public TemplateDetails getTemplateDetails() {
		return templateDetails;
	}

	public void setTemplateDetails(TemplateDetails templateDetails) {
		this.templateDetails = templateDetails;
	}

	public TemplateFtl getTemplate() {
		return template;
	}

	public void setTemplate(TemplateFtl template) {
		this.template = template;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
