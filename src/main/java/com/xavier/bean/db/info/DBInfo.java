package com.xavier.bean.db.info;


/**
 * <p>数据库连接详情Bean</p>
 *
 * @author NewGr8Player
 */
public class DBInfo {

	private String connectName;
	private String connectURL;
	private String driver;
	private String username;
	private String password;

	public DBInfo() {
		super();
	}

	public DBInfo(String connectName, String connectURL, String driver, String username, String password) {
		super();
		this.connectName = connectName;
		this.connectURL = connectURL;
		this.driver = driver;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBInfo{" +
				"connectName='" + connectName + '\'' +
				", connectURL='" + connectURL + '\'' +
				", driver='" + driver + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public String getConnectName() {
		return connectName;
	}

	public void setConnectName(String connectName) {
		this.connectName = connectName;
	}

	public String getConnectURL() {
		return connectURL;
	}

	public void setConnectURL(String connectURL) {
		this.connectURL = connectURL;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
