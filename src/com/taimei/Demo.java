package com.taimei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	public static void main(String[] args) {
		//lanmda初次尝试
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			list.add(i + "");
		}
		List<Integer> result = list.stream().filter(str -> Integer.valueOf(str) > 90).map(String::hashCode).collect(Collectors.toList());
		result.forEach(str -> System.err.println(str));
		int re = Stream.iterate(1, num -> num + 1).limit(100).reduce(0, (a, b) -> a + b);
		System.out.println(re);
		int size = list.stream().filter(str -> Integer.valueOf(str) > 90).mapToInt(String::hashCode).sum();
		System.out.println(size);
		//测试普通for循环和stream性能
		List<User> users = new ArrayList<User>();
		List<User2> ll = new ArrayList<User2>();
		User2 user2 = null;
		for (int i = 0; i < 10000000; i++) {
			user2 = new User2();
			user2.setDate("2016-01-01");
			user2.setName("1");
			user2.setPassword("1");
			ll.add(user2);
		}
		cc1(users, ll);
		cc2(users, ll);

	}

	private static void cc1(List<User> users, List<User2> ll) {
		long startTime = System.currentTimeMillis();
		users = ll.stream().map(user22 -> {
			User user = new User();
			user.setDate(user22.getDate());
			user.setName(user22.getName());
			user.setPassword(user22.getPassword());
			return user;
		}).collect(Collectors.toList());
		System.out.println("cc1:" + users.size());
		System.out.println("cc1处理时间(s):" + (System.currentTimeMillis() - startTime));
	}

	private static void cc2(List<User> users, List<User2> ll) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < ll.size(); i++) {
			User user = new User();
			user.setDate(ll.get(i).getDate());
			user.setName(ll.get(i).getName());
			user.setPassword(ll.get(i).getPassword());
			users.add(user);
		}
		System.out.println("cc2:" + users.size());
		System.out.println("cc2处理时间(s):" + (System.currentTimeMillis() - startTime));
	}

}
