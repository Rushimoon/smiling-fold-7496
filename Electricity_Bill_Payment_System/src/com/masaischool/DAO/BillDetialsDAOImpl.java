package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.BillDetialsDTOImpl;
import com.masaischool.DTO.CustomerDTOImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class BillDetialsDAOImpl {
     
	
	

	public List<BillDetialsDTOImpl> viewBillOfConsumer(int cid) throws SomeThingWrongException, NoRecordFoundException {
		
		Connection conn = null;
		List<BillDetialsDTOImpl> list; 
		try {
			conn = DBUtils.connectToDatabase();
			String query = "select * from bills where cid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
	        ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No bills in database");
			}
			
			list = new ArrayList<BillDetialsDTOImpl>();
//			int bill_no, int fixed_charge, int units_consumed, int tax, int tax_adjustment, int total,
//			String status, int cid, String month
			while(rs.next()) {
				list.add(new BillDetialsDTOImpl(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
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
	
	public List<BillDetialsDTOImpl> viewAllBills()throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		List<BillDetialsDTOImpl> list; 
		try {
			conn = DBUtils.connectToDatabase();
			String query = "select * from Bills";
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No customer in database");
			}
			
			list = new ArrayList<BillDetialsDTOImpl>();
			// String fname, String lname, String uname, String password, String number, String email
			while(rs.next()) {
				list.add(new BillDetialsDTOImpl(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
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
	public List<BillDetialsDTOImpl> viewAllBillsP()throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {
		Connection conn = null;
		List<BillDetialsDTOImpl> list; 
		try {
			conn = DBUtils.connectToDatabase();
			String query = "select * from Bills where status = 'paid' OR status='pending' ";
			PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No customer in database");
			}
			
			list = new ArrayList<BillDetialsDTOImpl>();
			// String fname, String lname, String uname, String password, String number, String email
			while(rs.next()) {
				list.add(new BillDetialsDTOImpl(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
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
