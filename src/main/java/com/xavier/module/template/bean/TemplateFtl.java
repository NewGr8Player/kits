package com.xavier.module.template.bean;

import org.springframework.util.StringUtils;

/**
 * <p>Ftl模板文件</p>
 */
public class TemplateFtl {

	private String name;/* 名字 */

	private String description;/* 描述 */

	private String fileName;/* 模板文件名 */

	private String targetPackage;/* 生成的目标包名 */

	private String targetPath;/* 模板生成的路径 */

	private String targetFileName;/* 生成的目标文件名 */

	private String type = "java";/* 类型，java代表java文件，其他则表是非java文件 */

	private String basePath = "/src/main";/* 模板根目录 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		if (StringUtils.hasText(basePath)) {
			this.basePath = basePath;
		}
	}
}
