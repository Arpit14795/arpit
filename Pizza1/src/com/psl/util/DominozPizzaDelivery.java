package com.psl.util;

import java.util.List;
import java.util.Map;




import com.psl.bean.NoSuchOrderFoundException;
import com.psl.bean.Order;
import com.psl.bean.Price;
import com.psl.bean.Topping;
import com.psl.bean.key;

public interface DominozPizzaDelivery {

	Map<key , Map<Topping , Price>> populateData(String toppingFile,String priceFile);
	List<Order> calculateOrder(String orderFile, Map<key , Map<Topping , Price>> map);
	Order chooseOrder(List<Order> order);
	Order CheckOrder(Order order, Map<key , Map<Topping , Price>> map) throws NoSuchOrderFoundException;
	void calculateBill(Order order, Map<key , Map<Topping , Price>> map);
}
