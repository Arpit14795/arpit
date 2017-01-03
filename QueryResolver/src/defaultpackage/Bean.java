package defaultpackage;

public class Bean 
{
	int a;
	float b;
	String c;
	E e;
	
	static enum E
	{
		A,B,C,D
	}
	
	public Bean()
	{
		super();
	}

	public Bean(int a, float b, String c, E e) 
	{
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.e = e;
	}

	@Override
	public String toString() {
		return "Bean [a=" + a + ", b=" + b + ", c=" + c + ", e=" + e + "]";
	}


	
}
