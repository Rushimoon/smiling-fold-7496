package com.masaischool.UI;

import java.util.Scanner;

import com.masaischool.DAO.CustomerDAO;
import com.masaischool.DAO.CustomerDAOImpl;
import com.masaischool.DTO.CustomerDTO;
import com.masaischool.DTO.CustomerDTOImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class MainUI {

	
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		AdminUI admin = new AdminUI();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			
		 admin.adminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}

	
	 static void customerLogin(Scanner sc) {
			System.out.print("Enter username ");
			String username = sc.next();
			System.out.print("Enter password ");
			String password = sc.next();
			CustomerDAO customer = new CustomerDAOImpl() ;
			try {
				if(customer.customerLogin(username, password))
				{
				 System.out.println(" Electricity Department  Welcomes you  "+username+"  ");
				}
			} catch (SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		 
	 }
	  static void customerSignUp(Scanner sc) {
          System.out.println("Enter your First Name");
		  String fname=sc.next();
		  System.out.println("Enter your Last Name");
		  String lname=sc.next();
		  System.out.println("Enter your User Name");
		  String uname=sc.next();
		  System.out.println("Enter your Password");
		  String password=sc.next();
		  System.out.println("Enter your Mobile Number");
		  String number=sc.next();
		  System.out.println("Enter your Email");
		  String email=sc.next();
		  
		  
		  CustomerDTO cus = new CustomerDTOImpl(fname, lname, uname, password, number, email);
          CustomerDAO cusDao = new CustomerDAOImpl();
          try {
			cusDao.addCustomer(cus);
			System.out.println("Customer Added Successfully");
		} catch (SomeThingWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
	  }
	
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1.Administrator Login\n2. Customer Login\n 3. customer SingUp \n 0. Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Thank you, Visit again");
					break;
				case 1:
					 adminLogin(sc);
					break;
				case 2:
					customerLogin(sc);
					break;
				case 3:
					customerSignUp(sc);
					break;	
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
	
	}
	

}
