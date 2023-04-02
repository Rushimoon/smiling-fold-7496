package com.masaischool.DTO;

public class CustomerDTOImpl implements CustomerDTO {
	
	  String fname;
	  String lname;
	  String uname;
	  String password;
	  String number;
	  String email;
	public CustomerDTOImpl(String fname, String lname, String uname, String password, String number, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
		this.number = number;
		this.email = email;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "||fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", mobile number=" + password
				+ ", Email=" + number + "||";
	}
	
}
