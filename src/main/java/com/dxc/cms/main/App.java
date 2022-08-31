package com.dxc.cms.main;

import java.util.Scanner;

import com.dxc.cms.dao.CanteenManagementDAOImpl;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int role;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your role\n1.Admin\n2.Customer\n3.Vendor");
		role=scanner.nextInt();
		switch(role) {
			case 1:
				doAdmin();
				break;
			case 2:
				doCustomer();
				break;
			case 3:
				doVendor();
				break;
			default:
				System.out.println("Not a valid user, try again");
				System.exit(0);
				break;
		}
		scanner.close();
	}
	
	public static void doAdmin() {
		Integer operation;
		Scanner scanner=new Scanner(System.in);
		CanteenManagementDAOImpl impl=new CanteenManagementDAOImpl();
		do {
			System.out.println("Enter operation to perform \n1.Add customer\n2.Remove customer\n3.Edit customer\n4.Search customer\n5.Show all customers");
			System.out.println("6.Add vendor\n7.Remove vendor\n8.Edit vendor\n9.Search vendor\n10.Show all vendors\n11.Exit");
			operation=scanner.nextInt();
			switch(operation) {
				case 1:
					impl.addCustomer();
					break;
				case 2:
					impl.removeCustomer();
					break;
				case 3:
					impl.editCustomer();
					break;
				case 4:
					impl.searchCustomerById();
					break;
				case 5:
					impl.getAllCustomers();
					break;
				case 6:
					impl.addVendor();
					break;
				case 7:
					impl.removeVendor();
					break;
				case 8: 
					impl.editVendor();
					break;
				case 9:
					impl.searchVendorById();
					break;
				case 10:
					impl.getAllVendors();
					break;
				case 11:
					System.out.println("Bye");
					System.exit(0);
				default:
					System.out.println("Not a valid operation");
					break;
			}						
		}while(true);
	}
	
	public static void doCustomer() {
		Integer operation;
		Scanner scanner=new Scanner(System.in);
		CanteenManagementDAOImpl impl=new CanteenManagementDAOImpl();
		do {
			System.out.println("Enter operation to perform \n1.Check wallet balance\n2.Place order\n3.Cancel order\n4.Exit");
			operation=scanner.nextInt();
			switch(operation) {
			case 1:
				impl.checkWalletBalance();
				break;
			case 2:
				impl.placeOrder();
				break;
			case 3:
				impl.cancelOrder();
				break;
			case 4:
				System.out.println("Bye");
				System.exit(0);
			default:
				System.out.println("Not a valid operation");
				break;
			}
		}while(true);
	}
	
	public static void doVendor() {
		Integer operation;
		Scanner scanner=new Scanner(System.in);
		CanteenManagementDAOImpl impl=new CanteenManagementDAOImpl();
		do {
			System.out.println("Enter operation to perform \n1.Add food\n2.Remove food\n3.Edit food\n4.Search food\n5.Show all food");
			System.out.println("6.Complete order\n7.View completed orders\n8.View pending orders\n9.View placed orders\n10.Exit");
			operation=scanner.nextInt();
			switch(operation) {
				case 1:
					impl.addFood();
					break;
				case 2:
					impl.removeFood();
					break;
				case 3:
					impl.editFood();
					break;
				case 4:
					impl.searchFoodById();
					break;
				case 5:
					impl.getAllFood();
					break;
				case 6:
					impl.completeOrder();
					break;
				case 7:
					impl.viewCompletedOrders();
					break;
				case 8: 
					impl.viewPendingOrders();
					break;
				case 9:
					impl.viewOrdersPlaced();
					break;
				case 10:
					System.out.println("Bye");
					System.exit(0);
				default:
					System.out.println("Not a valid operation");
					break;
			}						
		}while(true);
	}
}