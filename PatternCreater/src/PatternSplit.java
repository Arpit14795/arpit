import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PatternSplit {

	public static void main(String[] args) {
			Pattern pat=Pattern.compile("[ ,-/]");
		//	Matcher mat=pat.matcher("2,Jain,3/2/1997- Maharashtra,,456123,null");
//			while(mat.find())
//				System.out.println(mat.group());
		String [] arr= pat.split("  2,Jain,3/2/1997- Maharashtra, ,456123,null");
		 for (String string : arr) {
			System.out.println(string);
		}
	}

}
