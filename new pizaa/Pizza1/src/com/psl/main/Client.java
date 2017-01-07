package com.psl.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.psl.bean.Order;
import com.psl.bean.Price;
import com.psl.bean.Topping;
import com.psl.bean.key;
import com.psl.util.DominozPizzaDelivery;
import com.psl.util.DominozPizzaDeliveryImpl;

public class Client {

	public static void main(String[] args) {
		DominozPizzaDeliveryImpl impl=new DominozPizzaDeliveryImpl();
		
		
		
		impl.calculateBill(impl.chooseOrder(impl.calculateOrder("a", impl.populateData("a", "a"))),impl.populateData("a", "a"));
//		o.setToppingId(1267);
//		o.setKeyid(1);
//		impl.CheckOrder(o,impl.populateData("a","a"));
	}

}
