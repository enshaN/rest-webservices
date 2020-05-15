package com.project.rest.webservice.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
private int id;
@Size(min=2,message="name should have atleast 2 characters")
private String name;
@Past(message="date should be bfore current date")
private Date birthDate;
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
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public User(int id, String name, Date birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
}
	
}
