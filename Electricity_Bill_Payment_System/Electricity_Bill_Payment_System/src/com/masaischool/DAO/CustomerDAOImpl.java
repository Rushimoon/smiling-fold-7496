package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.masaischool.DTO.transactionHistory;
import com.masaischool.DTO.CustomerDTO;
import com.masaischool.DTO.CustomerDTOImpl;
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
	public int customerLogin(String username, String password) throws SomeThingWrongException, NoRecordFoundException {
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
			int Cid = rs.getInt(1);
		
	        return Cid;		
		}catch(SQLException ex) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
	public boolean  payCustomerBill(int Cid) throws NoRecordFoundException, SomeThingWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.connectToDatabase();
			String query = "update bills set status=paid WHERE Cid = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Cid);
			return true;
		}catch(SQLException ex) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	
	}
	
	
//	public static Map<String,String>  viewTransactionHistory() {
//		
//		
//		
//		
//	}
	
	
	public List<CustomerDTOImpl> viewAllCustomer()throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		List<CustomerDTOImpl> list; 
		try {
			conn = DBUtils.connectToDatabase();
			String query = "select * from customer where isdelete=0";
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No customer in database");
			}
			
			list = new ArrayList<CustomerDTOImpl>();
			// String fname, String lname, String uname, String password, String number, String email
			while(rs.next()) {
				list.add(new CustomerDTOImpl(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		}catch(SQLException ex) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
	
	public boolean deleteCustomer(String uname) throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException{
		Connection conn = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			String query = "update customer set isDelete=1 where user_name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, uname);
	       return ps.execute();
	    	   
	       	
			
	}catch(SQLException ex) {
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
		
	
	public List<transactionHistory> transactionHistory(int Cid)throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		List<transactionHistory> list; 
		try {
			conn = DBUtils.connectToDatabase();
			String query = " select b.cid ,c.first_name,b.total ,b.month ,b.status  from bills b inner join customer c on c.cid=b.cid  where c.cid=?";
			PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, Cid);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No customer in database");
			}
			
			list = new ArrayList<transactionHistory>();
		
			while(rs.next()) {
				list.add(new transactionHistory(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new SomeThingWrongException();
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
	
}
