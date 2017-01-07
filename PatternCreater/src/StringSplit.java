import java.util.Calendar;


public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr= "    2,Jain,3/2/1997- Maharashtra,,456123,null".split("[,/-]");
		 for (String string : arr) {
			System.out.println(string);
		}
		 
	}

}
