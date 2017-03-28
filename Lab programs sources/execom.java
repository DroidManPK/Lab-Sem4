import java.util.*;

class complex
{
		public int r,m;
		complex(int re,int im)
		{
			r=re;
			m=im;
		}
		public complex ad(int n,complex s1)
		{
			complex s3=new complex((n+s1.r),s1.m);
			return s3;
		}
		public complex ad(complex s1,complex s2)
		{
			complex s3=new complex((s2.r+s1.r),(s2.m+s1.m));
			return s3;
		}
		public void out()
		{
			System.out.println("The complex number is "+r+" +"+m+"i");
		}
}

class execom
{	static Scanner s=new Scanner(System.in);
	public static void main(String args[])
	{
	
	complex t;
	t=reader();
	System.out.println("Add real number (1) or Complex number (2) to it ?");
	if(s.nextInt()==1)
		{System.out.println("Enter the number :");
			t=t.ad(s.nextInt(),t);
			t.out();
		}
	else
		{	complex s2;
			s2=reader();
			s2=s2.ad(s2,t);
			s2.out();
		}
}

	public static complex reader()
	{
		System.out.println("Enter a complex number :");
			System.out.print("real part : ");
			int re=s.nextInt();
			System.out.print("imaginary part : ");
			int im=s.nextInt();
			
			complex t=new complex(re,im);
			t.out();
			return t;
	}

}