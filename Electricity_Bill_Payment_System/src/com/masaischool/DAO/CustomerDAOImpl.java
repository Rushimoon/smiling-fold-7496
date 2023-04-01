package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.masaischool.DTO.CustomerDTO;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class CustomerDAOImpl implements CustomerDAO {

	public void addCustomer(CustomerDTO customer) throws SomeThingWrongException {
		 
		Connection connection = null;
		try {
			connection = DBUtils.connectToDatabase();
			String INSERT_QUERY = "INSERT INTO customer (First_name ,Last_name ,User_name ,password ,Mobile_number,Email) VALUES (?,?,?,?,?,?)";
		    PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			ps.setString(1,customer.getFname());
		    ps.setString(2,customer.getLname());
			ps.setString(3,customer.getUname());
			ps.setString(4,customer.getPassword());
			ps.setString(5,customer.getNumber());
			ps.setString(6,customer.getEmail());
		    ps.executeUpdate();
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw new SomeThingWrongException();
		}
		finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean customerLogin(String username, String password) throws SomeThingWrongException, NoRecordFoundException {
		Connection conn = null;
		try {
			conn = DBUtils.connectToDatabase();
			String query = "SELECT Cid FROM customer WHERE user_name = ? AND password = ? AND isDelete = 0";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Invalid username or password");
			}
			
			rs.next();
			String name = rs.getString(1);
			System.out.println(name);
	      return true ;		
		}catch(SQLException ex) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
	
}
