package defaultpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Class1 
{
	String str="";
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	static int c=1;
	int a=c;
	Class1()
	{
		c++;
	}
	@Override
	public String toString() {
		return "Class1 "+str;
	}

	public static void main(String[] args) throws InterruptedException 
	{
		
        //Add all method
		
		Class1 c1=new Class1();
		Class1 c2=new Class1();
		Class1 c3=new Class1();
		
		Class1 c4=new Class1();
		Class1 c5=new Class1();
		List<Class1> l=new ArrayList<>();
		l.add(c1);
		l.add(c2);
		l.add(c3);
		HashMap<Class1,Integer> ts=new HashMap<>();
		ts.put(c5,2);
		List<Class1> list=new ArrayList<>();
		list.add(c4);
		list.add(c5);
		c1.str="equals";
		System.out.println(l);
		System.out.println(list);
		System.out.println("\n\n");
		list.addAll(l);
		c1.str="not equals";
		c2=null;
		c3=null;
		c4=null;
//		System.gc();
//		Thread.sleep(5000);
		list.get(1).str="null";
		System.out.println(list);
		System.out.println("\n\n");
		l.add(new Class1());
		list.removeAll(l);
		System.out.println(list);
		System.out.println(l);
//		System.out.println(list);
		
		
		//toArray()
		
		Set<Integer> s=new TreeSet<>();
		s.add(0);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		System.out.println(s);
		
	}
}
