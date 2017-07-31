package com.taimei;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class test {
	public static void main(String[] args) {
		List<Node> result = initData();
		Gson gson = new Gson();
		System.out.println(gson.toJson(getNodeInfo(result.get(0), result)));
	}

	private static Node getNodeInfo(Node node, List<Node> nodes) {
		String id = node.getId();
		List<Node> reuslt = getNodeListById(id, nodes);
		if (!reuslt.isEmpty()) {
			for (int i = 0; i < reuslt.size(); i++) {
				Node node2 = getNodeInfo(reuslt.get(i), nodes);
				node.getChild().add(node2);
			}
		}
		return node;
	}

	private static List<Node> getNodeListById(String id, List<Node> nodes) {
		List<Node> nodelist = new ArrayList<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPid().equals(id)) {
				nodelist.add(nodes.get(i));
			}
		}
		return nodelist;
	}

	private static List<Node> initData() {
		Node node = new Node("1", "中国", "");
		Node node2 = new Node("2", "北京", "1");
		Node node3 = new Node("3", "上海", "1");
		Node node4 = new Node("4", "黄浦区", "3");
		Node node5 = new Node("4", "黄浦区", "3");
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		return list;
	}

}
