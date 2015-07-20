package sales.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class User {

	private String username;
	private String password;
	
	protected User(){}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
