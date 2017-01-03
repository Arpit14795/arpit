package defaultpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Class3 
{
	public static void main(String[] args)
	{
		//List
		
		ArrayList<Bean> l1=new ArrayList<Bean>();
		l1.add(new Bean(1, 1.0f, "1", Bean.E.A));
		l1.add(new Bean(2, 2.0f, "2", Bean.E.B));
		l1.add(new Bean(3, 3.0f, "3", Bean.E.C));
		l1.add(new Bean(4, 4.0f, "4", Bean.E.D));
		//Collections.sort(h1);
		
		LinkedList<Bean> l2=new LinkedList<Bean>();
		l2.add(new Bean(1, 1.0f, "1", Bean.E.A));
		l2.add(new Bean(2, 2.0f, "2", Bean.E.B));
		l2.add(new Bean(3, 3.0f, "3", Bean.E.C));
		l2.add(new Bean(4, 4.0f, "4", Bean.E.D));
		//Collections.sort(l2); 
		
		//Set
		
		HashSet<Bean>h1=new HashSet<Bean>();
		h1.add(new Bean(1, 1.0f, "1", Bean.E.A));
		h1.add(new Bean(2, 2.0f, "2", Bean.E.B));
		h1.add(new Bean(3, 3.0f, "3", Bean.E.C));
		h1.add(new Bean(4, 4.0f, "4", Bean.E.D));
		
		//You can't sort HashSet directly.
		//If still you want to sort HashSet then give this reference to List(any of its child) or TreeSet and
		//(remember if it is non-primitive class then the class should implement Comparable or you have to 
		//define Comparator explicitly)
		//Then call Collection.sort on List and again give back the reference of List to hashSet
		//TreeSet will sort automatically in natural order and you can give back the reference to HashSet
		
		LinkedHashSet<Bean>h2=new LinkedHashSet<>();
		h2.add(new Bean(1, 1.0f, "1", Bean.E.A));
		h2.add(new Bean(2, 2.0f, "2", Bean.E.B));
		h2.add(new Bean(3, 3.0f, "3", Bean.E.C));
		h2.add(new Bean(4, 4.0f, "4", Bean.E.D));
		
		
		TreeSet<Bean>h3=new TreeSet<>();
		h3.add(new Bean(1, 1.0f, "1", Bean.E.A));
		h3.add(new Bean(2, 2.0f, "2", Bean.E.B));
		h3.add(new Bean(3, 3.0f, "3", Bean.E.C));
		h3.add(new Bean(4, 4.0f, "4", Bean.E.D));
		//To make any object valid for TreeSet its class should implement Comparable or we can define our Comparator
		
		//Map
		
		HashMap<Bean,Integer>m1=new HashMap<>();
		m1.put(new Bean(1, 1.0f, "1", Bean.E.A), 1);
		m1.put(new Bean(2, 2.0f, "2", Bean.E.B), 2);
		m1.put(new Bean(3, 3.0f, "3", Bean.E.C), 3);
		m1.put(new Bean(4, 4.0f, "4", Bean.E.D), 4);
		
		LinkedHashMap<Bean,Integer>m2=new LinkedHashMap<>();
		m2.put(new Bean(1, 1.0f, "1", Bean.E.A), 1);
		m2.put(new Bean(2, 2.0f, "2", Bean.E.B), 2);
		m2.put(new Bean(3, 3.0f, "3", Bean.E.C), 3);
		m2.put(new Bean(4, 4.0f, "4", Bean.E.D), 4);
		
		
		TreeMap<Bean,Integer>m3=new TreeMap<>();
		m3.put(new Bean(1, 1.0f, "1", Bean.E.A), 1);
		m3.put(new Bean(2, 2.0f, "2", Bean.E.B), 2);
		m3.put(new Bean(3, 3.0f, "3", Bean.E.C), 3);
		m3.put(new Bean(4, 4.0f, "4", Bean.E.D), 4);
	}
}
