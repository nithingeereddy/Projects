package net.app.model;

public class LogRegData {
private String username;
private String email;
private String password;
private String contact;
public LogRegData(String username, String email, String password, String contact) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.contact = contact;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}
}
