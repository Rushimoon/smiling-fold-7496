package com.masaischool.DTO;

public interface BillDetialsDTO {

	public int getBill_no() ;
	public void setBill_no(int bill_no);
	public int getFixed_charge();
	public void setFixed_charge(int fixed_charge) ;
	public int getUnits_consumed();
	public void setUnits_consumed(int units_consumed);
	public int getTax() ;
	public void setTax(int tax) ;
	public int getTax_adjustment() ;;
	public void setTax_adjustment(int tax_adjustment);
	public int getTotal() ;
	public void setTotal(int total) ;
	public String getStatus();
	public void setStatus(String status) ;
	public int getCid() ;
	public void setCid(int cid);
	public String getMonth();
	public void setMonth(String month) ;
	
}
