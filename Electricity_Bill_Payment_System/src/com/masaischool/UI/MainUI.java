package com.masaischool.UI;

import java.util.Scanner;

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
		
	 }
	
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1.Administrator Login\n2. Customer Login\n0. Exit");
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
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
	
	}
	

}
