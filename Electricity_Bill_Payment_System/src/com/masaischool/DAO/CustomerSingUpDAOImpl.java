package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.masaischool.DTO.CustomerSingUpDTO;
import com.masaischool.exception.SomeThingWrongException;

public class CustomerSingUpDAOImpl implements CustomerSingUpDAO {

	public void addCustomer(CustomerSingUpDTO customer) throws SomeThingWrongException {
		 
		Connection connection = null;
		try {
			
			connection = DBUtils.connectToDatabase();
			
			String INSERT_QUERY = "INSERT INTO customer (First_name ,Last_name ,User_name ,password ,Mobile_number ,Email varchar,) VALUES (?,?,?,?,?,?)";
			
		
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			
		    ps.setString(1,customer.getFname());
		    ps.setString(2,customer.getLname());
			ps.setString(3,customer.getUname());
			ps.setString(4,customer.getPassword());
			ps.setInt(5,customer.getNumber());
			ps.setString(6,customer.getEmail());
			
			
			
			
			ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			
			throw new SomeThingWrongException();
		}finally {
			try {
				
				DBUtils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				throw new SomeThingWrongException();
			}
		}
	}
	 
	
	
}
