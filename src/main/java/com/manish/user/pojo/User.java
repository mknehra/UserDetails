package com.manish.user.pojo;

import java.util.Objects;

import lombok.Data;

@Data
public class User {

	public int expiration;
	public String exposure;
	public String name;
	public String password;
	public String uidLink;
	public String userContent;
	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiration, exposure, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return expiration == other.expiration && Objects.equals(exposure, other.exposure)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	public User(int expiration, String exposure, String name, String password, String uidLink) {
		super();
		this.expiration = expiration;
		this.exposure = exposure;
		this.name = name;
		this.password = password;
		this.uidLink = uidLink;
	}
}
