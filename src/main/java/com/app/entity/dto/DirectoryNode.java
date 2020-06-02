package com.app.entity.dto;

public class DirectoryNode {
	private String name;
	private String path;
	private String type;
	private String size;
	private DirectoryNode children[];
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public DirectoryNode[] getChildren() {
		return children;
	}
	public void setChildren(DirectoryNode[] children) {
		this.children = children;
	}
	
	
	
}
