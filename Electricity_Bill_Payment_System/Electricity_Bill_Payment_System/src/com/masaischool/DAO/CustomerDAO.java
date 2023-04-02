package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.CustomerDTO;
import com.masaischool.DTO.CustomerDTOImpl;
import com.masaischool.DTO.transactionHistory;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface CustomerDAO {
  
	public void addCustomer(CustomerDTO customer) throws SomeThingWrongException;
	public int customerLogin(String username, String password) throws SomeThingWrongException, NoRecordFoundException ;
	public boolean payCustomerBill(int Cid) throws NoRecordFoundException, SomeThingWrongException;
	public List<CustomerDTOImpl> viewAllCustomer()throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException;
	public boolean deleteCustomer(String uname) throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException;
	public List<transactionHistory> transactionHistory(int Cid)throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException ;
}
