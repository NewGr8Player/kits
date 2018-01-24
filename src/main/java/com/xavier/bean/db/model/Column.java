package com.xavier.bean.db.model;

import com.xavier.service.db.connection.util.TypeUtil;
import com.xavier.util.StringUtil;

import java.io.Serializable;

/**
 * <p>列处理Bean</p>
 *
 * @Author NewGr8Player
 */
public class Column implements Serializable {

	protected int jdbcType;
	protected String jdbcTypeName;

	private String columnName;
	private boolean primaryKey;
	private boolean foreignKey;
	private int size;
	private int decimalDigits;
	private boolean nullable;
	private boolean unique;
	private boolean indexed;
	private boolean autoincrement;
	private String defaultValue;
	private String remarks;
	private String javaProperty;
	private String javaType;
	private String fullJavaType;
	private String editor;
	private boolean display = true;
	private boolean searchable;
	private boolean sortable = false;
	private String dict = "";

	public Column(String columnName) {
		this.columnName = columnName;
		this.javaProperty = StringUtil.getCamelCaseString(columnName, false);
	}

	public String getJavaPrimitiveType() {
		if (TypeUtil.isInteger(javaType)) {
			return "int";
		} else if (TypeUtil.isDouble(javaType)) {
			return "double";
		} else if (TypeUtil.isFloat(javaType)) {
			return "float";
		} else if (TypeUtil.isLong(javaType)) {
			return "long";
		} else if (TypeUtil.isShort(javaType)) {
			return "short";
		} else if (TypeUtil.isBoolean(javaType)) {
			return "boolean";
		} else if (TypeUtil.isByte(javaType)) {
			return "byte";
		} else {
			return javaType;
		}
	}

	public boolean isPrimitiveType() {
		/* int, double, float, long, short, boolean, byte, char */
		return TypeUtil.isInteger(javaType) || TypeUtil.isDouble(javaType)
				|| TypeUtil.isFloat(javaType) || TypeUtil.isLong(javaType)
				|| TypeUtil.isShort(javaType) || TypeUtil.isBoolean(javaType)
				|| TypeUtil.isByte(javaType);
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String getDefaultValue() {
		return defaultValue == null ? "" : defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getRemarks() {
		return remarks == null ? "" : remarks.trim();
	}

	public boolean isHasRemarks() {
		return StringUtil.isNotEmptyOrBlank(remarks);
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksUnicode() {
		return StringUtil.toUnicodeString(getRemarks());
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaProperty() {
		return javaProperty;
	}

	public int getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(int jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJdbcTypeName() {
		return jdbcTypeName;
	}

	public void setJdbcTypeName(String jdbcTypeName) {
		this.jdbcTypeName = jdbcTypeName;
	}

	public boolean isString() {
		return TypeUtil.isString(javaType);
	}

	public boolean isFloatNumber() {
		return TypeUtil.isFloat(javaType) || TypeUtil.isDouble(javaType)
				|| TypeUtil.isBigDecimal(javaType) || TypeUtil.isBigInteger(javaType);
	}

	public boolean isIntegerNumber() {
		return TypeUtil.isByte(javaType) || TypeUtil.isShort(javaType)
				|| TypeUtil.isInteger(javaType) || TypeUtil.isLong(javaType);
	}

	public boolean isBigDecimal() {
		return TypeUtil.isBigDecimal(javaType);
	}

	public boolean isBoolean() {
		return TypeUtil.isBoolean(javaType);
	}

	public boolean isDate() {
		return TypeUtil.isDate(javaType);
	}

	public boolean isBLOB() {
		String typeName = getJdbcTypeName();
		boolean isBlob = "BINARY".equals(typeName);
		isBlob = isBlob || "BLOB".equals(typeName);
		isBlob = isBlob || "CLOB".equals(typeName);
		isBlob = isBlob || "LONGVARBINARY".equals(typeName);
		isBlob = isBlob || "LONGVARCHAR".equals(typeName);
		isBlob = isBlob || "VARBINARY".equals(typeName);
		return isBlob;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean isForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(boolean foreignKey) {
		this.foreignKey = foreignKey;
	}

	public void setJavaProperty(String javaProperty) {
		this.javaProperty = javaProperty;
	}

	public String getGetterMethodName() {
		StringBuilder sb = new StringBuilder();
		sb.append(javaProperty);
		if (Character.isLowerCase(sb.charAt(0)) && ((sb.length() == 1) || Character.isLowerCase(sb.charAt(1)))) {
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		}
		if (TypeUtil.isBoolean(javaType)) {
			sb.insert(0, "is");
		} else {
			sb.insert(0, "get");
		}

		return sb.toString();
	}

	public String getSetterMethodName() {
		StringBuilder sb = new StringBuilder();

		sb.append(javaProperty);
		if (Character.isLowerCase(sb.charAt(0)) && ((sb.length() == 1) || Character.isLowerCase(sb.charAt(1)))) {
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		}

		sb.insert(0, "set");

		return sb.toString();
	}

	public String getFullJavaType() {
		return fullJavaType;
	}

	public void setFullJavaType(String fullJavaType) {
		this.fullJavaType = fullJavaType;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public boolean isAutoincrement() {
		return autoincrement;
	}

	public void setAutoincrement(boolean autoincrement) {
		this.autoincrement = autoincrement;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public String getDict() {
		return dict;
	}

	public boolean hasDict() {
		return StringUtil.isNotEmptyOrBlank(dict);
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

}
