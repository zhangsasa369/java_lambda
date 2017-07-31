package com.taimei;

import java.util.ArrayList;
import java.util.List;

public class User {
	String name;
	String password;
	String date;

	String ssString;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSsString() {
		return ssString;
	}

	public void setSsString(String ssString) {
		this.ssString = ssString;
	}

	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setDate("2017-01-01" + i);
			user.setName("name" + i);
			user.setPassword("11111111" + i);
			list.add(user);
			user = null;
		}
		for (User u : list) {
			System.out.print(u.getDate());
			System.out.print(u.getName());
			System.out.print(u.getPassword());
			System.out.println();

		}

	}

}
