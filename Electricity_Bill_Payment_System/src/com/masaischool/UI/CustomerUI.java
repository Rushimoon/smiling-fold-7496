package com.masaischool.UI;

import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.CustomerDAO;
import com.masaischool.DAO.CustomerDAOImpl;
import com.masaischool.DTO.transactionHistory;
import com.masaischool.custom.ConsoleColors;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class CustomerUI {
   public static void payElectricBill(Scanner sc ,int Cid) {
	  
	   System.out.println(ConsoleColors.RED_BOLD+"Please enter your debitcard number");
	   long debit_no=sc.nextLong();
	   System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+ " Please enter your debitcard password");
	   int pass =sc.nextInt();
	   CustomerDAO custo = new CustomerDAOImpl();
	   try {
	 if	(custo.payCustomerBill(Cid))
	 {
		System.out.println(ConsoleColors.GREEN_BACKGROUND+"Your Electricity Bill Was Paid Sucessfully"); 
	 }
	} catch (NoRecordFoundException | SomeThingWrongException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   } 
	
	
	
   public static void viewTransactionHistory(int Cid) {
	  // select b.cid ,c.first_name,b.total ,b.month ,b.status  from bills b inner join customer c on c.cid=b.cid  where c.cid=3 ;
		
	   CustomerDAO custo = new CustomerDAOImpl();
	   try {
		List<transactionHistory> th =custo.transactionHistory(Cid);
		for(transactionHistory x : th) {
			System.out.println(x.toString());
		}
	} catch (ClassNotFoundException | SomeThingWrongException | NoRecordFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   ;
	}
	
	
	public static void  customer_menu(Scanner sc ,int Cid) {
//		System.out.println("press 1 to pay your electric  bill");
//		System.out.println("press 2 to view your transaction history ");
		System.out.println(ConsoleColors.ORANGE +"==============================================="+"\n"
				            +ConsoleColors.CYAN +"| Press 1 To Pay Your Electric  Bill           |"+"\n"
				          +ConsoleColors.ORANGE +"| Press 2 to View Your Transaction History     |"+"\n"
				             +ConsoleColors.CYAN+"===============================================" +ConsoleColors.RESET);
		int selection =sc.nextInt();
		switch (selection) {
		case 1: payElectricBill(sc,Cid);
		case 2:	viewTransactionHistory(Cid);
		
		}
		
		
		
	}






	
	
	
	
}
