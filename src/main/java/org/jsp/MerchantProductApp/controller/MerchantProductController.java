package org.jsp.MerchantProductApp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.MerchantProductApp.Dao.MerchantDao;
import org.jsp.MerchantProductApp.Dao.ProductDao;
import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class MerchantProductController {
	static Scanner sc=new Scanner(System.in);
	static MerchantDao mdao=new MerchantDao();
	static ProductDao pdao=new ProductDao();
	public static void main(String[] args) {
		System.out.println("1. Save Merchant Info ");
		System.out.println("2.Update Merchant ");
		System.out.println("3. Find Merchant By Id ");
		System.out.println("4. Find Merchant By Email and Password ");
		System.out.println("5. Verify Merchant by Phone and Password ");
		
		System.out.println("6.Add Product ");
		System.out.println("7. Update Product ");
		System.out.println("8. Find Product By Id ");
		System.out.println("9. Find Product By Brand and Category ");
		System.out.println("10. Find Products By Merchant Id ");
		
		System.out.println("Enter the Choice ");
		int choice =sc.nextInt();
		switch (choice) {
		
		case 1:saveMerchant();
		break;
		
		case 2:updateMerchant();
		break;
		
		case 3:findMerchantById();
		break;
		
		case 4:findMerchantByEmailandPassword();
		break;
		
		case 5:verifyMerchantByPhoneAndPassword();
		break;
		
		case 6:addProduct();
		break;
		
		case 7:updateProduct();
		break;
		
		case 8:findProducyById();
		break;
		
		case 9:findProductByBrandAndCategory();
		break;
		
		case 10:findProductByMerchantId();
		break;
		
		default:
			System.err.println("The choice Number is Invalid");
			break;
		}
	}
	private static void findProductByMerchantId() {
		System.out.println("Enter Merchant id to find Products");
		int mid=sc.nextInt();
		List<Product> lpdb=pdao.findProductByMerchantId(mid);
		if(lpdb.size()>0) {
			for (Product product : lpdb) {
				System.out.println(product);
			}
		}
		else {
			System.err.println("No prodcts are found since Merchant id is inavlid");
		}
		
	}
	private static void findProductByBrandAndCategory() {
		System.out.println("Enter the brand");
		String br=sc.next();
		System.out.println("Enter the category");
		String cat=sc.next();
		List<Product> lpList=pdao.findProductByBrandAndCategory(br,cat);
		if(lpList.size()>0) {
			for (Product product : lpList) {
				System.out.println(product);
			}
		}
		else {
			System.err.println("No products is found since brand is not present in the database table");
		}
	}
		
	
	private static void findProducyById() {
		System.out.println("Enter Merchant id to find Products");
		int mid=sc.nextInt();
		List<Product> lpdb=pdao.findProductById(mid);
		if(lpdb.size()>0) {
			for (Product product : lpdb) {
				System.out.println(product);
			}
		}
		else {
			System.err.println("No prodcts are found since Merchant id is inavlid");
		}
		
	}
	private static void updateProduct() {
		System.out.println("Enter the product info---id,name,brand,category,cost");
		Product p = new Product();
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
		Product pdb=pdao.updateProduct(p);
		if(pdb!=null) {
			System.out.println("Product is updated : "+pdb);
		}
		else {
			System.err.println("Unable to update the product since id is invalid");
		}
	}
		
	
	private static void addProduct() {
		System.out.println("Enter the Merchant Id:");
		int mid=sc.nextInt();
		System.out.println("Insert product Info..name,brand,category,cost");
		Product p=new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
		Product pdb=pdao.addProduct(mid,p);
		if(pdb!=null) {
			System.out.println("Product is added to Merchant with Id "+p.getId());
		}else {
			System.err.println("No Merchant Found");
		}
		
	}
	private static void verifyMerchantByPhoneAndPassword() {
		System.out.println("Enter Phone Number:");
		Long ph=sc.nextLong();
		System.out.println("Enter the Password");
		String pw=sc.next();
		Merchant mdb=mdao.findMerchantByPhoneAndPassword(ph,pw);
		if(mdb!=null) {
			System.out.println(mdb);
			}else {
				System.err.println("No record found");
			}
		
		
	}
	private static void findMerchantByEmailandPassword() {
		System.out.println("Enter the Email");
		String em=sc.next();
		System.out.println("Enter the Password");
		String pw=sc.next();
		Merchant mdb=mdao.findMerchantByEmailAndPassword(em,pw);
		if(mdb!=null) {
			System.out.println(mdb);
			}else {
				System.err.println("No record found");
			}
		
	}
	private static void findMerchantById() {
		System.out.println("Enter the Merchant Id");
		int mid = sc.nextInt();
		Merchant mdb = mdao.findMerchantById(mid);
		if(mdb!=null) {
			System.out.println(mdb);
			}else {
				System.err.println("No record found");
			}
		
		
	}
	private static void updateMerchant() {
		System.out.println("Insert the Merchant Info..id,name,gst_num,email,phone,password");
		Merchant m=new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPhone(sc.nextLong());
		m.setPassword(sc.next());
		Merchant mdb=mdao.updateMerchant(m);
		if(mdb!=null) {
			System.out.println("Merchant record is updated with id "+mdb.getId());
			}else {
				System.err.println("No record is updated since id is invalid");
			}
	}
	private static void saveMerchant() {
		System.out.println("Insert the Merchant Info..name,gst_num,email,phone,password");
		Merchant m=new Merchant();
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPhone(sc.nextLong());
		m.setPassword(sc.next());
		
		Merchant mdb=mdao.saveMerchant(m);
		System.out.println("Merchant record is inserted with id "+mdb.getId());
		
	}

}
