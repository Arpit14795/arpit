package com.psl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.psl.bean.NoSuchOrderFoundException;
import com.psl.bean.Order;
import com.psl.bean.Price;
import com.psl.bean.Topping;
import com.psl.bean.key;

public class DominozPizzaDeliveryImpl implements DominozPizzaDelivery {

	@Override
	public Map<key, Map<Topping, Price>> populateData(String toppingFile,
			String priceFile) {
		Map<key, Map<Topping, Price>> map = new HashMap<key, Map<Topping, Price>>();
		Map<Topping, Price> m = null;
		map.put(key.VegPizza, new HashMap<Topping, Price>());
		map.put(key.NonvegPizza, new HashMap<Topping, Price>());
		String line[] = null;
		try (Scanner sc = new Scanner(new FileInputStream(toppingFile))) {
			while (sc.hasNext()) {
				line = sc.nextLine().split(",");
				Topping t = new Topping();
				if (Integer.parseInt(line[0].trim()) == 1) {
					// Veg
					t.setKeyid(1);
					m = map.get(key.VegPizza);
				} else {
					// NonVeg
					t.setKeyid(2);
					m = map.get(key.NonvegPizza);
				}
				t.setToppingId(Integer.parseInt(line[1].trim()));
				t.setToppingName(line[2].trim().substring(1,
						line[2].trim().length() - 1));
				t.setTimeToCook(Double.parseDouble(line[3].trim()));
				m.put(t, new Price());

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Scanner sc = new Scanner(new FileInputStream(priceFile))) {

			while (sc.hasNext()) {
				line = sc.nextLine().split(",");
				int tid = Integer.parseInt(line[0].trim());
				for (Map.Entry<key, Map<Topping, Price>> me1 : map.entrySet()) {
					for (Map.Entry<Topping, Price> me : me1.getValue()
							.entrySet()) {
						if (me.getKey().getToppingId() == tid) {
							me.getValue().setToppingId(tid);
							me.getValue().setCost(
									Double.parseDouble(line[1].trim()));
						}
					}
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public List<Order> calculateOrder(String orderFile,
			Map<key, Map<Topping, Price>> map) {
		List<Order> list = new ArrayList<Order>();
		String line[] = null;
		try (Scanner sc = new Scanner(new FileInputStream(orderFile))) {
			while (sc.hasNext()) {
				line = sc.nextLine().split(",");
				Order o = new Order();
				o.setKeyid(Integer.parseInt(line[0].trim()));
				o.setToppingId(Integer.parseInt(line[1].trim()));
				o.setsize(line[2].trim());
				o.setToppingName(line[3].trim().substring(1,
						line[3].trim().length() - 1));

				list.add(o);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Order chooseOrder(List<Order> order) {
		Order o = null;
		int index = (int) (Math.random() * order.size());

		o = order.get(index);

		return o;
	}

	@Override
	public Order CheckOrder(Order order, Map<key, Map<Topping, Price>> map)
			throws NoSuchOrderFoundException {
		Order o = null;

		for (Map.Entry<key, Map<Topping, Price>> me1 : map.entrySet()) {
			if (me1.getKey().getVal() == order.getKeyId()) {
				for (Map.Entry<Topping, Price> me : me1.getValue().entrySet()) {
					if (me.getKey().getToppingId() == order.getToppingId()) {
						o = order;
					}
				}
			}
		}

		if (o == null) {
			throw new NoSuchOrderFoundException("Invalid Order");
		}
		return o;
	}

	@Override
	public void calculateBill(Order order, Map<key, Map<Topping, Price>> map) {
		// TODO Auto-generated method stub
		for (Map.Entry<key, Map<Topping, Price>> me1 : map.entrySet()) {
			if (me1.getKey().getVal() == order.getKeyId()) {
				for (Map.Entry<Topping, Price> me : me1.getValue().entrySet()) {
					if (me.getKey().getToppingId() == order.getToppingId()) {
						double price = me.getValue().getCost();
						switch (order.getsize()) {
						case "small":
							if (me.getKey().getTimeToCook() <= 30) {
								order.setCost(me.getValue().getCost());
							} else {
								order.setCost(me.getValue().getCost()
										+ me.getKey().getTimeToCook());
							}
							break;
						case "medium":
							if (me.getKey().getTimeToCook() <= 30) {
								order.setCost(2*me.getValue().getCost());
							} else {
								order.setCost(2*me.getValue().getCost()
										+ me.getKey().getTimeToCook());
							}

							break;
						case "large":
							if (me.getKey().getTimeToCook() <= 30) {
								order.setCost(3*me.getValue().getCost());
							} else {
								order.setCost(3*me.getValue().getCost()
										+ me.getKey().getTimeToCook());
							}
							break;
						default:
							// System.out.println("ERoorrrrrrrrr");
							break;

						}

					}
				}
			}
		}
	}

}
