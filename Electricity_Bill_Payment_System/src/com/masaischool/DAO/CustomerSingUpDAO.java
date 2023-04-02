package com.masaischool.DAO;

import com.masaischool.DTO.CustomerSingUpDTO;
import com.masaischool.exception.SomeThingWrongException;

public interface CustomerSingUpDAO {
  
	public void addCustomer(CustomerSingUpDTO customer) throws SomeThingWrongException;
 
}
