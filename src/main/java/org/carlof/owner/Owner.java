package org.carlof.owner;

import java.util.List;
import java.util.Set;

import org.carlof.cat.Cat;

public class Owner {

	int id;
	String name;
	Set<Cat> cats;
	
	public Owner() {
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

	public Set<Cat> getCats() {
		return cats;
	}

	public void setCats(Set<Cat> cats) {
		this.cats = cats;
	}
	
	
	
	
}
