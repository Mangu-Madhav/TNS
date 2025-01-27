package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class users {
	
	@Id
private int id;
private String name;
private String type;
private String password;
public users() 
{ super();
	
	}
public users(int id, String name,String type, String password) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.password = password;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "users [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
}
}

