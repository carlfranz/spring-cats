package org.carlof.cat;

public class Cat {

	private int id;

	private String name;
	private String kind;

	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	

}
