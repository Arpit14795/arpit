package defaultpackage;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

public class Class2 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> al=new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		
		Set<Integer> s=new LinkedHashSet<>(al);
		System.out.println(s);
		al.set(0, 6);
		System.out.println(al);
		System.out.println(s);
		
		TreeMap<Integer,Integer> m=new TreeMap<>();
	
		m.put(1, 2);
		m.put(10, 2);
		m.put(100, 2);
		System.out.println(m.firstKey()+" "+m.lastKey());
		System.out.println(m);
		m.clear();
		System.out.println(m);
	}
}
