package com.masaischool.DTO;

public class BillDetialsDTOImpl implements BillDetialsDTO {

	int bill_no;
	int fixed_charge;
    int  units_consumed ; 
    int tax ;
    int tax_adjustment ; 
    int total  ;
    String Status ;
    int Cid ;
    String month;
	public BillDetialsDTOImpl(int bill_no, int fixed_charge, int units_consumed, int tax, int tax_adjustment, int total,
			String status, int cid, String month) {
		super();
		this.bill_no = bill_no;
		this.fixed_charge = fixed_charge;
		this.units_consumed = units_consumed;
		this.tax = tax;
		this.tax_adjustment = tax_adjustment;
		this.total = total;
		Status = status;
		Cid = cid;
		this.month = month;
	}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public int getFixed_charge() {
		return fixed_charge;
	}
	public void setFixed_charge(int fixed_charge) {
		this.fixed_charge = fixed_charge;
	}
	public int getUnits_consumed() {
		return units_consumed;
	}
	public void setUnits_consumed(int units_consumed) {
		this.units_consumed = units_consumed;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getTax_adjustment() {
		return tax_adjustment;
	}
	public void setTax_adjustment(int tax_adjustment) {
		this.tax_adjustment = tax_adjustment;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "BillDetialsImpl [bill_no=" + bill_no + ", fixed_charge=" + fixed_charge + ", units_consumed="
				+ units_consumed + ", tax=" + tax + ", tax_adjustment=" + tax_adjustment + ", total=" + total
				+ ", Status=" + Status + ", Cid=" + Cid + ", month=" + month + "]";
	}
	
}
