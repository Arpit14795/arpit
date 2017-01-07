import java.util.Calendar;
import java.util.StringTokenizer;


public class Stringtokenizer {

	public static void main(String[] args) {

		StringTokenizer st=new StringTokenizer("   2,Jain,3/2/1997- Maharashtra, ,456123,null",
				"[, /-]",false);
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
		 Calendar c=Calendar.getInstance();
	//	 c.
	}

}
