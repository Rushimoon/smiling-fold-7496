package com.masaischool.UI;

import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.BillDetialsDAO;
import com.masaischool.DAO.BillDetialsDAOImpl;
import com.masaischool.DAO.CustomerDAO;
import com.masaischool.DAO.CustomerDAOImpl;
import com.masaischool.DTO.BillDetialsDTO;
import com.masaischool.DTO.BillDetialsDTOImpl;
import com.masaischool.DTO.CustomerDTOImpl;
import com.masaischool.custom.ConsoleColors;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public  class AdminUI {

	public static void viewAllCustomer() throws ClassNotFoundException, SomeThingWrongException, NoRecordFoundException {
		
		CustomerDAO customer_detials =new CustomerDAOImpl();
		List<CustomerDTOImpl> list= customer_detials.viewAllCustomer();
		System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		for(CustomerDTOImpl x : list){

             System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+ x.toString());
            System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		}
	}
	
	
	 public static void  viewBillOfConsumer(Scanner sc) throws SomeThingWrongException, NoRecordFoundException {
		 
		 System.out.println("Please  Enter the customer id  to view bill");
		 int cid=sc.nextInt();
		 BillDetialsDAOImpl bill = new BillDetialsDAOImpl();
		List<BillDetialsDTOImpl> list =  bill.viewBillOfConsumer(cid);
		System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		for(BillDetialsDTOImpl x : list)
		{
			System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+x.toString()+ConsoleColors.RESET);
			System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		}
		 
	 }
	
	 
	 public static void viewAllbills() throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {

		
		 BillDetialsDAOImpl bill = new BillDetialsDAOImpl();
		List<BillDetialsDTOImpl> list =  bill.viewAllBills();
		System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		for(BillDetialsDTOImpl x : list)
		{
			System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+x.toString()+ConsoleColors.RESET);
			System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		}
	 }
	 public static void viewAllbillsP() throws SomeThingWrongException, NoRecordFoundException, ClassNotFoundException {
		
		
		 BillDetialsDAOImpl bill = new BillDetialsDAOImpl();
		List<BillDetialsDTOImpl> list = bill.viewAllBillsP();
		System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		for(BillDetialsDTOImpl x : list)
		{
			System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+x.toString()+ConsoleColors.RESET);
			System.out.println(ConsoleColors.RED_BOLD+ "-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+ConsoleColors.RESET);
		}
	 }
	 
	 public static void  deleteConsumer(Scanner sc) throws ClassNotFoundException, SomeThingWrongException, NoRecordFoundException {
		 
		 System.out.println("enter user name to be deleted");
		 String uname =sc.next();
		 CustomerDAO customer_detials =new CustomerDAOImpl();
         boolean result =customer_detials.deleteCustomer(uname);
//		 if(result)
//		 {
//			 System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"consumer deleted Successfully"+ConsoleColors.RESET);
//		 }
		 
	 }
	 
	
	public static void adminMenu(Scanner sc) throws ClassNotFoundException {
		System.out.println(ConsoleColors.ORANGE +"==============================================="+"\n"
	                        +ConsoleColors.CYAN +"| Press 1 To View All Consumers                |"+"\n"
                          +ConsoleColors.ORANGE +"| Press 2 To View Bill of the consumer         |"+"\n"
                           +ConsoleColors.CYAN  +"| Press 3 View all the bills of all consumer   |"+"\n"
                          +ConsoleColors.ORANGE +"| Press 4 View all bills paid and pending      |"+"\n"
	                        +ConsoleColors.CYAN +"| Press 5 Delete consumer                      |"+"\n"
				                                +"===============================================" +ConsoleColors.RESET);
		
		
//		System.out.println("Press 1 View all consumers. ");
//		System.out.println("Press 2 View the bill of the consumer. ");
//		System.out.println("Press 3 View all the bills.");
//		System.out.println("Press 4 View all bills paid and pending.");
//		System.out.println("Press 5 Delete consumer.");
		
	    int selection = sc.nextInt();
	     switch(selection)
	     { 
	     case 1 :    try {
				viewAllCustomer();
			} catch (ClassNotFoundException | SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	       break;
	     case 2 :   
			try {
				viewBillOfConsumer(sc);
			} catch (SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	               break;
	     case 3 :  try {
				viewAllbills();
			} catch (SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	               break;
	     case 4 :     try {
				    viewAllbillsP();
			} catch (SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	               break;
	     case 5 : try {
	    	 deleteConsumer(sc); 
	    	 System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"consumer deleted Successfully"+ConsoleColors.RESET);
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	               break;
	    
  	       
	     
	     }
		
	  }
}
