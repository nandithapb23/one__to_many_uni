package com.ty.onetomany_uni.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id

private int id;
private String name;
private String address;
@OneToMany
private List<Students>list;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public List<Students> getList() {
	return list;
}
public void setList(List<Students> list) {
	this.list = list;
}
@Override
public String toString() {
	return "School [id=" + id + ", name=" + name + ", address=" + address + ", list=" + list + "]";
}

}
