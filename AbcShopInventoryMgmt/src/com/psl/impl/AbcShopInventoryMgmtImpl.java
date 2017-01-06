package com.psl.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.psl.bean.HardwareProduct;
import com.psl.bean.Product;
import com.psl.bean.SoftwareProduct;
import com.psl.enums.OperatingSystem;
import com.psl.enums.ProductType;

public class AbcShopInventoryMgmtImpl {

	public static void main(String[] args) {
		
		Product pro=null;
		SoftwareProduct sp=null;
		HardwareProduct hp=null;
		ArrayList<Product> list=new ArrayList<Product>();
		Scanner sc=null;
		String lineRead;
		String arr[];
		try {
			sc = new Scanner(new FileInputStream("item.txt"));
			while(sc.hasNext()){
				lineRead=sc.nextLine();
				arr=lineRead.split(",");

				if(arr.length==7){
					//softwareProduct
					pro=new SoftwareProduct();
					for (int i=0;i<arr.length;i++) {
						
						arr[i]=arr[i].trim();
					}
					
					pro.setProductId(Integer.parseInt(arr[0]));
					pro.setSerialNo(Integer.parseInt(arr[1]));
					pro.setProductName(arr[2]);
					pro.setCategory(ProductType.valueOf(arr[3]));
					
					sp=(SoftwareProduct)pro;
					sp.setOperatingSystem(OperatingSystem.valueOf(arr[4]));
					sp.setMemory(arr[5]);
					sp.setLicenceKe(arr[6]);
					list.add(pro);
				}
				else{
					//hardwareProduct
					pro=new HardwareProduct();
					for (int i=0;i<arr.length;i++) {
						
						arr[i]=arr[i].trim();
					}
					
					pro.setProductId(Integer.parseInt(arr[0]));
					pro.setSerialNo(Integer.parseInt(arr[1]));
					pro.setProductName(arr[2]);
					pro.setCategory(ProductType.valueOf(arr[3]));
					
					hp=(HardwareProduct)pro;
					hp.setDimensions(arr[4]);
					hp.setCapacity(Integer.parseInt(arr[5]));
					hp.setBrand(arr[6]);
					hp.setPowerSupplyRequirement(arr[7]);
					hp.setBatteryBackup(arr[8]);
					list.add(pro);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			sc.close();
		}
		
		System.out.println(list);
		

	}

}
