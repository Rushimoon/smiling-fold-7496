package com.masaischool.UI;

import java.util.Scanner;

import com.masaischool.DAO.CustomerSingUpDAO;
import com.masaischool.DAO.CustomerSingUpDAOImpl;
import com.masaischool.DTO.CustomerSingUpDTO;
import com.masaischool.DTO.CustomerSingUpDTOImpl;
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
		  int number=sc.nextInt();
		  System.out.println("Enter your Email");
		  String email=sc.next();
		  
		  
		  CustomerSingUpDTO cus = new CustomerSingUpDTOImpl(fname, lname, uname, password, number, email);
          CustomerSingUpDAO cusDao = new CustomerSingUpDAOImpl();
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
