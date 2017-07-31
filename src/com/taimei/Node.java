package com.taimei;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String		id;
	private String		nodeName;
	private String		pid;
	private List<Node>	child	= new ArrayList<Node>();

	public String getId() {

		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeName() {

		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getPid() {

		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Node(String id, String nodeName, String pid) {
		super();
		this.id = id;
		this.nodeName = nodeName;
		this.pid = pid;
	}

	public Node() {
		super();
	}

	public List<Node> getChild() {

		return child;
	}

	public void setChild(List<Node> child) {
		this.child = child;
	}

}
