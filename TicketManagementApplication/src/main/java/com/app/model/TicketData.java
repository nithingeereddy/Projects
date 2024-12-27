package com.app.model;

public class TicketData {
private int ticketId;
private String type;
private String priority;
private String issueDetails;
private String employeeName;
public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
public String getIssueDetails() {
	return issueDetails;
}
public void setIssueDetails(String issueDetails) {
	this.issueDetails = issueDetails;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public TicketData(int ticketId, String type, String priority, String issueDetails, String employeeName) {
	super();
	this.ticketId = ticketId;
	this.type = type;
	this.priority = priority;
	this.issueDetails = issueDetails;
	this.employeeName = employeeName;
}
public TicketData() {
	super();
	this.ticketId = ticketId;
	this.type = type;
	this.priority = priority;
	this.issueDetails = issueDetails;
	this.employeeName = employeeName;
}

}
