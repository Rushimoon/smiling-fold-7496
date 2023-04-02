package com.masaischool.DTO;

public class transactionHistory {
	int cid ;
	String first_name;
	int total ;
	String month ;
	String status ;  
	public transactionHistory(int cid, String first_name, int total, String month, String status) {
		super();
		this.cid = cid;
		this.first_name = first_name;
		this.total = total;
		this.month = month;
		this.status = status;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "transactionHistory [cid=" + cid + ", first_name=" + first_name + ", total=" + total + ", month=" + month
				+ ", status=" + status + "]";
	}
	
	
}
