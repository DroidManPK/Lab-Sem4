import java.util.*;

class CUBE_
{
	double s,v,oa;
	CUBE_(double side)
	{
		s=side;
		v=s*s*s;
		oa=s*s*6.0;
	}
	public String toString()
	{
		return "Volume : "+v+" Outer area : "+oa;
	}
}
class cube
{
	public static void main(String arg[])
	{
		System.out.println("Enter the number of cubes : ");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		CUBE_[] c=new CUBE_[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the side of cube "+(i+1));
			c[i]=new CUBE_(s.nextDouble());
			System.out.println(c[i]);
		}
	}
}		
			
		