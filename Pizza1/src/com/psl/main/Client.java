package com.psl.main;

import java.util.List;
import java.util.Map;

import com.psl.bean.NoSuchOrderFoundException;
import com.psl.bean.Order;
import com.psl.bean.Price;
import com.psl.bean.Topping;
import com.psl.bean.key;
import com.psl.util.DominozPizzaDeliveryImpl;

public class Client {

	public static void main(String[] args) {
	DominozPizzaDeliveryImpl dpdi = new DominozPizzaDeliveryImpl();	
	Map<key, Map<Topping, Price>> map=dpdi.populateData("topping.txt", "price.txt");
	System.out.println(map);
	
	
	List<Order> order=dpdi.calculateOrder("order.txt", map);
	System.out.println(order);
	try {
		dpdi.CheckOrder(new Order(), map);
	} catch (NoSuchOrderFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Order o=dpdi.chooseOrder(order);
	
	System.out.println(o+"\n-----------");
	dpdi.calculateBill(o, map);
	System.out.println(o);
	
	}

}
