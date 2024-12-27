package app.net.Model;

public class Patient {
	private int patientNo;
	private String patientName;
	private String location;
	private String issue;
	private String contact;
	public int getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Patient() {
		super();
	}
	public Patient(int patientNo, String patientName, String location, String issue, String contact) {
		super();
		this.patientNo = patientNo;
		this.patientName = patientName;
		this.location = location;
		this.issue = issue;
		this.contact = contact;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}
