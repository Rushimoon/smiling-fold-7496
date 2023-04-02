package com.masaischool.UI;

import java.io.Console;
import java.util.Scanner;

import com.masaischool.DAO.CustomerDAO;
import com.masaischool.DAO.CustomerDAOImpl;
import com.masaischool.DTO.CustomerDTO;
import com.masaischool.DTO.CustomerDTOImpl;
import com.masaischool.custom.ConsoleColors;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public class MainUI {

	
	
	static void adminLogin(Scanner sc) throws ClassNotFoundException {
		System.out.print(ConsoleColors.RED_BOLD+ "Enter username ");
		String username = sc.next();
		System.out.print(ConsoleColors.RED_BOLD_BRIGHT+ "Enter password ");
		String password = sc.next();
		AdminUI admin = new AdminUI();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
		   int exit;
		   System.out.println(ConsoleColors.GREEN+ "   Admin Login Successfull..!! "+ConsoleColors.YELLOW+ " \n     Select Below Options  " +ConsoleColors.RESET);
		   admin.adminMenu(sc);
		   do {
				System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"press 0 to goto main menu");
				System.out.println(ConsoleColors.BROWN+ "press 1 to continue admin menu");
				
				exit=sc.nextInt();
				if(exit==1)
			      {
					 admin.adminMenu(sc);
			      }
				
			}
			while(exit!=0);
	
		 
		}else {
			System.out.println("Invalid Username and Password");
		}
	}

	
	 static void customerLogin(Scanner sc) {
			System.out.print(ConsoleColors.CYAN+ "Enter username "+ConsoleColors.RESET);
			String username = sc.next();
			System.out.print(ConsoleColors.CYAN+"Enter password "+ConsoleColors.RESET);
			String password = sc.next();
			CustomerDAO customer = new CustomerDAOImpl() ;
			try {
				int Cid =customer.customerLogin(username, password);
				if(Cid>0)
				{
				 	
				 System.out.println(ConsoleColors.GREEN+ " Electricity Department  Welcomes you  "+username+"  ");
				 System.out.println("your customer id is  "+Cid+ConsoleColors.RESET);
				 CustomerUI custo = new CustomerUI();
				  custo.customer_menu(sc,Cid);
				}
				
			} catch (SomeThingWrongException | NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		 
	 }
	  static void customerSignUp(Scanner sc) {
          System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+ "Enter your First Name");
		  String fname=sc.next();
		  System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+ "Enter your Last Name");
		  String lname=sc.next();
		  System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter your User Name");
		  String uname=sc.next();
		  System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter your Password");
		  String password=sc.next();
		  System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter your Mobile Number");
		  String number=sc.next();
		  System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter your Email");
		  String email=sc.next();
		  System.out.println(ConsoleColors.RESET);
		  
		  CustomerDTO cus = new CustomerDTOImpl(fname, lname, uname, password, number, email);
          CustomerDAO cusDao = new CustomerDAOImpl();
          try {
			cusDao.addCustomer(cus);
			System.out.println(ConsoleColors.GREEN+ "Customer Added Successfully"+ConsoleColors.RESET);
		} catch (SomeThingWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
	  }
	
	public static void main(String[] args) throws ClassNotFoundException {
	   Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			//System.out.println("1.Administrator Login\n2. Customer Login\n 3. customer SingUp \n 0. Exit");
			System.out.println(ConsoleColors.CYAN_UNDERLINED+ConsoleColors.BANANA_YELLOW+"Welcome To Electricity Bill Payment System");
			System.out.println("Select following choices"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.ORANGE +"===================================="+"\n"
					            +ConsoleColors.CYAN +"| Press 1 for Administrator Login  |"+"\n"
					          +ConsoleColors.ORANGE +"| Press 2 for Customer Login       |"+"\n"
					           +ConsoleColors.CYAN  +"| Press 3 for Customer Singup      |"+"\n"
                               +ConsoleColors.ORANGE+"====================================" +ConsoleColors.RESET);
			
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+ "Thank you, Visit again"+ConsoleColors.RESET);
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
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ "Invalid Selection, try again"+ConsoleColors.RESET);
			}
		}while(choice != 0);
		sc.close();
	
	}
	

}
