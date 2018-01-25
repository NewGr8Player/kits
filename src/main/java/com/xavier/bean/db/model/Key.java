package com.xavier.bean.db.model;

import java.io.Serializable;

/**
 * <p>键信息Bean</p>
 *
 * @author NewGr8Player
 */
public class Key implements Serializable {

	private String pkTableName;
	private String pkColumnName;
	private String fkTableName;
	private String fkColumnName;
	private Integer seq;

	public Key(String pkTableName, String pkColumnName, String fkTableName, String fkColumnName, Integer seq) {
		super();
		this.pkTableName = pkTableName;
		this.pkColumnName = pkColumnName;
		this.fkTableName = fkTableName;
		this.fkColumnName = fkColumnName;
		this.seq = seq;
	}

	public String getPkTableName() {
		return pkTableName;
	}

	public void setPkTableName(String pkTableName) {
		this.pkTableName = pkTableName;
	}

	public String getPkColumnName() {
		return pkColumnName;
	}

	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}

	public String getFkTableName() {
		return fkTableName;
	}

	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}

	public String getFkColumnName() {
		return fkColumnName;
	}

	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}
