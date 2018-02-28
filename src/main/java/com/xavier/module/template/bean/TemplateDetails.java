package com.xavier.module.template.bean;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>模板基本信息类</p>
 */
public class TemplateDetails {


	private String name;/* 模板名字 */

	private String author;/* 作者名称 */

	private String url;/* 作者链接 */

	private String description;/* 模板描述 */

	private String path;

	private List<TemplateFtl> templates;/* 模板文件 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TemplateFtl> getTemplates() {
		return templates;
	}

	public void setTemplates(List<TemplateFtl> templates) {
		this.templates = templates;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return StringUtils.hasText(name) ? name : path;
	}
}
