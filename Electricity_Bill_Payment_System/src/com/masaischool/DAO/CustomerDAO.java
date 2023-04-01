package com.masaischool.DAO;

import com.masaischool.DTO.CustomerDTO;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface CustomerDAO {
  
	public void addCustomer(CustomerDTO customer) throws SomeThingWrongException;
	public boolean customerLogin(String username, String password) throws SomeThingWrongException, NoRecordFoundException ;
 
}
