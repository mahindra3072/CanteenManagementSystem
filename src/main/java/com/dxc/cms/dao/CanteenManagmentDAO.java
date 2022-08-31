package com.dxc.cms.dao;

public interface CanteenManagmentDAO {
	
	void addCustomer();
	void removeCustomer();
	void editCustomer();
	void searchCustomerById();
	void getAllCustomers();
	
	void addVendor();
	void removeVendor();
	void editVendor();
	void searchVendorById();
	void getAllVendors();

	void addFood();
	void removeFood();
	void editFood();
	void searchFoodById();
	void getAllFood();
	
	void placeOrder();
	void checkWalletBalance();
	void viewOrdersPlaced();
	void viewPendingOrders();
	void viewCompletedOrders();
	void cancelOrder();
	void completeOrder();
}