package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

import com.psl.bean.Order;
import com.psl.bean.Price;
import com.psl.bean.Topping;
import com.psl.bean.key;
import com.psl.exception.NoSuchOrderFound;

public class DominozPizzaDeliveryImpl implements DominozPizzaDelivery {

	@Override
	public Map<key, Map<Topping, Price>> populateData(String toppingFile,
			String priceFile) {
		// TODO Auto-generated method stub
		Map<key, Map<Topping, Price>> returnMap = new HashMap<key, Map<Topping, Price>>();

		// iterate by key and put inside map empty map
		for (key k : key.values()) {
			returnMap.put(k, new HashMap<Topping, Price>());
		}

		// raw database
		Map<Topping, Price> insideMap = new HashMap<Topping, Price>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("topping.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (sc.hasNext()) {
			Scanner sc1 = null;
			try {
				sc1 = new Scanner(new File("price.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("1111");
			String line = sc.nextLine();
			if (!line.equals("")) {
				String token[] = line.split(",", 4);

				Topping t = new Topping();

				int Keyid = Integer.parseInt(token[0].trim());

				int ToppingId = Integer.parseInt(token[1].trim());
				String ToppingName = token[2].trim();
				double timeToCook = Double.parseDouble(token[3].trim());
				t.setToppingId(ToppingId);
				t.setKeyid(Keyid);
				t.setTimeToCook(timeToCook);
				t.setToppingName(ToppingName);
				// System.out.println(t);
				Price p = null;

				while (sc1.hasNext()) {
					// System.out.println("hello@@@@@@@");

					String line1 = sc1.nextLine();
					if (!line1.equals("")) {
						String token1[] = line1.split(",", 2);
						int top_id = Integer.parseInt(token1[0].trim());

						// System.out.println("helo");

						// System.out.println(top_id == ToppingId);
						if (top_id == ToppingId) {
							// System.out.println();
							p = new Price();
							p.setToppingId(top_id);
							p.setCost(Double.parseDouble(token1[1].trim()));
							insideMap.put(t, p);
							System.out.println("@@@@");
						}

					}
				}

			}
		}

		for (Map.Entry<key, Map<Topping, Price>> entry : returnMap.entrySet()) {
			for (Map.Entry<Topping, Price> en : insideMap.entrySet()) {
				if ((entry.getKey().ordinal() + 1) == en.getKey().getKeyId()) {
					Map<Topping, Price> tempMap = new HashMap<Topping, Price>();
					tempMap.put(en.getKey(), en.getValue());

					entry.getValue().putAll(tempMap);

					returnMap.put(entry.getKey(), entry.getValue());
				}
			}
		}

		System.out.println(returnMap);

		return returnMap;
	}

	@Override
	public List<Order> calculateOrder(String orderFile,
			Map<key, Map<Topping, Price>> map) {

		// TODO Auto-generated method stub
		List<Order> listOforder = new ArrayList<Order>();
		try {
			Scanner sc = new Scanner(new File("order.txt"));
			while (sc.hasNext()) {
				String line = sc.nextLine();
				if (!line.equals("")) {
					
					String token[]=line.split(",",4);
					
					int Keyid=Integer.parseInt(token[0].trim());
					int ToppingId=Integer.parseInt(token[1].trim());
				   String ToppingName=token[3].trim();
					 String size=token[2].trim();
					double cost = 0;
					
					
					
					
					for (Map.Entry<key, Map<Topping, Price>> entry : map
							.entrySet()) {
						
						if((entry.getKey().ordinal()+1)==Keyid)
						{
							for(Map.Entry<Topping, Price> en:entry.getValue().entrySet())
							{
								if(en.getKey().getToppingId()==ToppingId)
								{
									cost=en.getValue().getCost();
								}
							}
						}
					}
					
					Order o=new Order();
					o.setCost(cost);
					o.setKeyid(Keyid);
					o.setsize(size);
					o.setToppingId(ToppingId);
					o.setToppingName(ToppingName);
					
					listOforder.add(o);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(listOforder);
		return listOforder;
	}

	@Override
	public Order chooseOrder(List<Order> order) {
		// TODO Auto-generated method stub
		
		//Collections.shuffle(order);
		Random rand=new Random();
		int index=rand.nextInt(order.size());
		Order o=order.get(index);
		System.out.println(o);
		return o;
	}

	@Override
	public Order CheckOrder(Order order, Map<key, Map<Topping, Price>> map) {
		// TODO Auto-generated method stub
		int Keyid=order.getKeyId();
		int ToppingId=order.getToppingId();
		int count=0;
		
		for(Map.Entry<key, Map<Topping, Price>> entry:map.entrySet())
		{
			if(Keyid==(entry.getKey().ordinal()+1))
			{
				for(Map.Entry<Topping, Price> en:entry.getValue().entrySet())
				{
					if(en.getKey().getToppingId()==ToppingId)
					{
						count++;
						break;
					}
				}
			}
		}
		
		Order o=null;
		if(count==0)
		{
			try {
				throw new NoSuchOrderFound();
			} catch (NoSuchOrderFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else
		{
			o=order;
		}
		System.out.println(o);
		return o;
		
	}

	@Override
	public void calculateBill(Order order, Map<key, Map<Topping, Price>> map) {
		// TODO Auto-generated method stub

		Order o=CheckOrder(order, map);
		if(o!=null)
		{
			String size=o.getsize().toUpperCase();
			int top_id=o.getToppingId();
			int key_id=o.getKeyId();
			double timeToCook=0.0D;
			double cost=0.0;
			for(Map.Entry<key, Map<Topping, Price>> entry:map.entrySet())
			{
				if((entry.getKey().ordinal()+1)==key_id)
				{
					for(Map.Entry<Topping, Price> en:entry.getValue().entrySet())
					{
						if(en.getKey().getToppingId()==top_id)
						{
							timeToCook=en.getKey().getTimeToCook();
							cost=en.getValue().getCost();
						}
					}
				}
			}
			
			switch (size) {
			case "REGULAR":
			case "SMALL":
				
					if(timeToCook<30)
					{
						cost=cost;
						o.setCost(cost);
					}
					else if(timeToCook>30)
					{
						cost=cost+timeToCook*10;
						o.setCost(cost);
						
					}
				break;

			case "MEDIUM":
				
				if(timeToCook<30)
				{
					cost=2*cost;
					o.setCost(cost);
				}
				else if(timeToCook>30)
				{
					cost=2*cost+timeToCook*10;
					o.setCost(cost);
					
				}
			break;
			
			case "LARGE":
				
				if(timeToCook<30)
				{
					cost=3*cost;
					o.setCost(cost);
				}
				else if(timeToCook>30)
				{
					cost=3*cost+timeToCook*10;
					o.setCost(cost);
					
				}
			break;
			default:
				break;
			}
			
			
		}
		
		System.out.println(o);
	}

}
