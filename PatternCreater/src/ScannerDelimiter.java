import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ScannerDelimiter 

{
	
	public static void main(String[] args) throws FileNotFoundException 
	{
        /*  Scanner sc=new Scanner("  2,Jain,3/2/1997- Maharashtra, ,456123,null");
          sc.useDelimiter(Pattern.compile("[ ,/-]"
          		+ ""));*/
		Scanner sc=new Scanner(new File("Txt"));
		//sc.useDelimiter(Pattern.compile("[ ,/-]"));
		int a=1;
          while(sc.hasNext())
          {
        	  System.out.println(sc.next());
        	  System.out.println(a++);
          }
	}
	
}
