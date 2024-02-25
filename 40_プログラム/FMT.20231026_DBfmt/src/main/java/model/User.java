package model;

import java.io.Serializable;

public class User implements Serializable{
	private String loginId;
	private String pass;
	
	public User() {}
	
	public User(String loginId, String pass) {
		this.loginId = loginId;
		this.pass = pass;
	}
	
	public String getLoginId() {
		return loginId;
	}
	public String getPass() {
		return pass;
	}
}
