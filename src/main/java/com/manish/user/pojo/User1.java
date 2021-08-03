package com.manish.user.pojo;

import java.util.Objects;

import lombok.Data;

@Data
public class User1 {
	public String username;
	public String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public User1(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User1 other = (User1) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	public User1() {
		super();
	}
}
