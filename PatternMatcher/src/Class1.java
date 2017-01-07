import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Class1 
{

	public static void main(String[] args) 
	{
		int a[]={45,12,4,8,34,76,34};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 4));
		
	/*	HashMap<Collection<?>,String> hm=new HashMap<>();
		Set<String> set=new HashSet<>();
		hm.put(set, new String("set"));
		List <Map<Integer,String>>list=new ArrayList<>();
		hm.put(list, new String("list"));*/
		
		
		HashMap<Set<String>, String> hm = new HashMap<Set<String>, String>();
		Set<Map<Integer, String>> s = new HashSet<Map<Integer,String>>();
		ArrayList<Long> al = new ArrayList<Long>();
		al.add((long)1);
		show("aakash");
		
	}
	public static <T> T show (T t )
	
	{
		System.out.println("value of t is : " + t);
		return t;
	}

}
