package com.katpro.model;
public class CustomerData {
    private String receiptNo;
    private String name;
    private String date;
    private String location;
    private String tax;
    private String total;

    public CustomerData(String receiptNo, String name, String date,String location,String tax,String total) {
        this.receiptNo = receiptNo;
        this.name = name;
        this.date=date;
        this.location=location;
        this.tax=tax;
        this.total = total;
        
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {
    	this.date=date;
    }
    public String getDate() {
    	return date;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
}
