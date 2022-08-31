package com.dxc.cms.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dxc.cms.db.DBConnection;
import com.dxc.cms.entity.Customer;
import com.dxc.cms.entity.Food;
import com.dxc.cms.entity.FoodOrder;
import com.dxc.cms.entity.Vendor;
//import com.sun.tools.jdeprscan.scan.Scan;

public class CanteenManagementDAOImpl implements CanteenManagmentDAO{
	
	private List<Customer>customerList=new ArrayList<>();
	private List<Vendor>vendorList=new ArrayList<>();
	private List<Food>foodList=new ArrayList<>();
	private List<FoodOrder>foodOrderList=new ArrayList<>();
	private Connection connection=null;
	private PreparedStatement statement=null;
	private ResultSet resultSet=null;
	
	public CanteenManagementDAOImpl() {
		try {
			connection=DBConnection.getConnection();
			System.out.println(connection);
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("hello");
		}
	}

	@Override
	public void addCustomer(){

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter customer name");
		String cname=scanner.nextLine();
		System.out.println("Enter customer phone number");
		String cphone=scanner.nextLine();
		System.out.println("Enter customer email address");
		String cemail=scanner.nextLine();
		System.out.println("Enter customer wallet balance");
		double cwalletbalance=scanner.nextDouble();
		String sql="insert into Customer values(?,?,?,?,?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			statement.setString(2, cname);
			statement.setString(3, cphone);
			statement.setString(4, cemail);
			statement.setDouble(5, cwalletbalance);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void removeCustomer() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		String sql="delete from customer where cid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void editCustomer() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		System.out.println("Enter the field to be modified ");
		System.out.println("1.Name\n2.phone\n3.Email");
		int option=scanner.nextInt();
		String sql;
		int n;
		try {
			switch (option) {

				case 1:
					System.out.println("Enter the modified name");
					scanner.nextLine();
					String name=scanner.nextLine();
					sql = "update customer set cname=? where cid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,name);
					statement.setInt(2,cid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				case 2:
					System.out.println("Enter the modified phone");
					scanner.nextLine();
					String phone=scanner.nextLine();
					sql = "update customer set cphone=? where cid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,phone);
					statement.setInt(2,cid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				case 3:
					System.out.println("Enter the modified email");
					scanner.nextLine();
					String email=scanner.nextLine();
					sql = "update customer set cemail=? where cid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,email);
					statement.setInt(2,cid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				default:
					System.out.println("wrong option");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void searchCustomerById() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id");
		int cid=scanner.nextInt();
		String sql="select*from customer where cid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, cid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getDouble(5));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getAllCustomers() {
		String sql="select*from customer";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getDouble(5));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void addVendor() {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter vendor name");
		String vname=sc.nextLine();
		System.out.println("Enter vendor phone number");
		String vphone=sc.nextLine();
		System.out.println("Enter vendor email (optional)");
		String vemail=sc.nextLine();
		String sql="insert into vendor(vname,vphone,vemail) values(?,?,?)";
		try{
			statement=connection.prepareStatement(sql);
			statement.setString(1,vname);
			statement.setString(2,vphone);
			statement.setString(3,vemail);
			int n=statement.executeUpdate();

			if(n>0){
				System.out.println(n+" rows affected");
			}


		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void removeVendor() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		String sql="delete from vendor where vid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, vid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}


	}

	@Override
	public void editVendor() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		System.out.println("Enter the field to be modified ");
		System.out.println("1.Vendor Name\n2.Vendor Phone\n3.Vendor Email(optional)");
		int option=scanner.nextInt();
		String sql;
		int n;
		try {
			switch (option) {

				case 1:
					System.out.println("Enter the modified name");
					scanner.nextLine();
					String name=scanner.nextLine();
					sql = "update vendor set vname=? where vid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,name);
					statement.setInt(2,vid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				case 2:
					System.out.println("Enter the modified phone");
					scanner.nextLine();
					String phone=scanner.nextLine();
					sql = "update vendor set vphone=? where vid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,phone);
					statement.setInt(2,vid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				case 3:
					System.out.println("Enter the modified email");
					scanner.nextLine();
					String email=scanner.nextLine();
					sql = "update vendor set vemail=? where vid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,email);
					statement.setInt(2,vid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				default:
					System.out.println("wrong option");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void searchVendorById() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		String sql="select*from vendor where vid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, vid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void getAllVendors() {
		String sql="select*from vendor";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void addFood() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter food name");
		String fname=scanner.nextLine();
		System.out.println("Enter food price");
		double fprice=scanner.nextDouble();
		String sql="insert into food(fname,fprice) values(?,?)";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setDouble(2, fprice);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}


	}

	@Override
	public void removeFood() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=scanner.nextInt();
		String sql="delete from food where fid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, fid);
			int n=statement.executeUpdate();
			if(n>=0)
				System.out.println(n+" records affected");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}



	}

	@Override
	public void editFood() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter food id");
		int fid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the field to be modified ");
		System.out.println("1.Food Name\n2.Food Price");
		int option=scanner.nextInt();
		String sql;
		int n;
		try {
			switch (option) {

				case 1:
					System.out.println("Enter the modified name");
					scanner.nextLine();
					String name=scanner.nextLine();
					sql = "update food set fname=? where fid=?";
					statement = connection.prepareStatement(sql);
					statement.setString(1,name);
					statement.setInt(2,fid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				case 2:
					System.out.println("Enter the new price");
					scanner.nextLine();
					double price=scanner.nextDouble();
					sql = "update food set fprice=? where fid=?";
					statement = connection.prepareStatement(sql);
					statement.setDouble(1,price);
					statement.setInt(2,fid);
					n=statement.executeUpdate();
					if(n>=0)
						System.out.println(n+" records affected");
					break;

				default:
					System.out.println("wrong option");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void searchFoodById() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Food Id");
		int fid=scanner.nextInt();
		String sql="select*from food where fid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, fid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void getAllFood() {

		String sql="select*from food";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getDouble(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void placeOrder() {
	  String defstat="pending";
      Scanner scanner=new Scanner(System.in);
	  System.out.println("Enter the customer id");
	  int cid=scanner.nextInt();
	  System.out.println("Enter the food to order");
	  scanner.nextLine();
	  String item= scanner.nextLine();
	  System.out.println("Enter the vendor id");
	  int vid=scanner.nextInt();
	  System.out.println("Enter remarks");
	  scanner.nextLine();
	  String remark=scanner.nextLine();
	  try{
		  statement=connection.prepareStatement("select fid from food where fname=?");
		  statement.setString(1,item);
		  resultSet=statement.executeQuery();
		  resultSet.next();
		  int fid=resultSet.getInt(1);
		  String sql="insert into foodorder(cid,vid,fid,orderdate,orderstatus,remark) values(?,?,?,now(),?,?)";
		  statement=connection.prepareStatement(sql);
		  statement.setInt(1,cid);
		  statement.setInt(2,vid);
		  statement.setInt(3,fid);
		  statement.setString(4,defstat);
		  statement.setString(5,remark);
		  int n=statement.executeUpdate();

		  if(n>0){
			  System.out.println("Order placed successfully!");
		  }



	  }catch(SQLException e){
		  System.out.println(e.getMessage());
	  }

	}

	@Override
	public void checkWalletBalance() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the customer id");
		int cid=scanner.nextInt();
		String sql="select cwalletbalance from customer where cid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,cid);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				System.out.println("wallet balance : "+resultSet.getDouble(1));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void viewOrdersPlaced() {


		String sql="select  fo.orderid,f.fname,v.vname,f.fprice ,fo.orderdate,fo.orderstatus,fo.remark from  foodorder fo,food f,customer c ,vendor v where fo.fid=f.fid and fo.cid=c.cid and fo.vid=v.vid;";
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n","OrderId","FoodItem","VendorName","FoodPrice","OrderDate","OrderStatus","Remark");
			while(resultSet.next()) {
				System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void viewPendingOrders() {


		String sql="select  fo.orderid,f.fname,v.vname,f.fprice ,fo.orderdate,fo.orderstatus,fo.remark from  foodorder fo,food f,customer c ,vendor v where fo.fid=f.fid and fo.cid=c.cid and fo.vid=v.vid and fo.orderstatus=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1,"pending");
			resultSet=statement.executeQuery();
			System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n","OrderId","FoodItem","VendorName","FoodPrice","OrderDate","OrderStatus","Remark");
			while(resultSet.next()) {
				System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void viewCompletedOrders() {


		String sql="select  fo.orderid,f.fname,v.vname,f.fprice ,fo.orderdate,fo.orderstatus,fo.remark from  foodorder fo,food f,customer c ,vendor v where fo.fid=f.fid and fo.cid=c.cid and fo.vid=v.vid and fo.orderstatus=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1,"completed");
			resultSet=statement.executeQuery();
			System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n","OrderId","FoodItem","VendorName","FoodPrice","OrderDate","OrderStatus","Remark");
			while(resultSet.next()) {
				System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void cancelOrder() {

        Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the customer id");
		int cid=scanner.nextInt();
		String sql="select  fo.orderid,f.fname,v.vname,f.fprice ,fo.orderdate,fo.orderstatus,fo.remark from  foodorder fo,food f,customer c ,vendor v where fo.fid=f.fid and fo.cid=c.cid and fo.vid=v.vid and c.cid=?;";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,cid);
			resultSet=statement.executeQuery();
			System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n","OrderId","FoodItem","VendorName","FoodPrice","OrderDate","OrderStatus","Remark");
			while(resultSet.next()) {
				System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7));
			}
			scanner.nextLine();
			System.out.println("Enter the order id");
			int orderid= scanner.nextInt();
			sql="delete from foodorder where orderid=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,orderid);
			int n=statement.executeUpdate();
			if(n>0){
				System.out.println("The order has been deleted successfully!");
			}


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void completeOrder() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the vendor id");
		int vid=scanner.nextInt();
		String sql="select  fo.orderid,f.fname,v.vname,f.fprice ,fo.orderdate,fo.orderstatus,fo.remark from  foodorder fo,food f,customer c ,vendor v where fo.fid=f.fid and fo.cid=c.cid and fo.vid=v.vid and v.vid=?";
		try{
			statement=connection.prepareStatement(sql);
			statement.setInt(1,vid);
			resultSet=statement.executeQuery();
			System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n","OrderId","FoodItem","VendorName","FoodPrice","OrderDate","OrderStatus","Remark");
			while(resultSet.next()){
				System.out.printf("%-10s %-20s %-20s %-20s  %-20s  %-20s  %-20s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getString(7));
			}
			System.out.println("Enter the order id to complete");
			scanner.nextLine();
			int orderid=scanner.nextInt();
			sql="select  c.cid,f.fprice ,c.cwalletbalance from  foodorder fo,food f,customer c  where fo.fid=f.fid and fo.cid=c.cid  and fo.orderid=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,orderid);
			resultSet=statement.executeQuery();
			resultSet.next();
			int cid=resultSet.getInt(1);
			double fprice=resultSet.getDouble(2);
			double cwalletbalance=resultSet.getDouble(3);

			if(cwalletbalance>=fprice){
				double diff=cwalletbalance-fprice;
				sql="update customer set cwalletbalance=? where customer.cid=?";
				statement=connection.prepareStatement(sql);
				statement.setDouble(1,diff);
				statement.setInt(2,cid);
				int n=statement.executeUpdate();
				sql="update foodorder set orderstatus=? where orderid=?";
				statement=connection.prepareStatement(sql);
				statement.setString(1,"completed");
				statement.setInt(2,orderid);
				int n2=statement.executeUpdate();
				if(n>0 && n2>0){
					System.out.println("Order processed successfully!");
				}


			}else{

				System.out.println("The order cannot be processed due to low wallet balance");
			}

		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

}