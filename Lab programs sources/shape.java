import java.util.*;

abstract class shap
{
	double area;
	abstract void calc();
}

class rect extends shap
{
	double s1,s2;
	rect(double a,double b)
	{
		s1=a;s2=b;
	}
	void calc()
	{
		area=s1*s2;
	}
	public String toString()
	{calc();
		return "The area of the Rectangle is "+area+" sq units";
	}
}

class tri extends shap
{
	double x,y,z;
	tri(double a,double b,double c)
	{
		x=a;y=b;z=c;
	}
	void calc()
	{
		double s4 = (x + y + z )/ 2 ;
        area = Math.sqrt(s4 * (s4 - x) * (s4 - y) * (s4 - z));
    }
    public String toString()
    {
    	calc();
    	return "Area of Triangle is :"+area+" sq units";
    }
   }
   
class circ extends shap
{	
	double rad;
	circ(double a)
	{
		rad=a;
	}
	void calc()
	{
		area=3.14*rad*rad;
	}
	public String toString()
    {calc();
    	return "Area of Circle is :"+area+" sq units";
    }
}

class shape
{
	public static void main(String arg[])
	{
	Scanner s=new Scanner(System.in);
	shap sh;
	while(true)
	{
	System.out.println("1-Rectangle\n2-triangle\n3-Circle\n4-exit");
	switch(s.nextInt())
	{
		case 1:System.out.println("Enter two sides : ");
				sh=new rect(s.nextDouble(),s.nextDouble());
				System.out.println(sh);
				break;
		case 2:System.out.println("Enter three sides : ");
				sh=new tri(s.nextDouble(),s.nextDouble(),s.nextDouble());
				System.out.println(sh);
				break;
		case 3:System.out.println("Enter radius : ");
				sh=new circ(s.nextDouble());
				System.out.println(sh);
				break;
		case 4:System.exit(0);
		default:System.out.println("Invalid choice");
	}
	}
	}
	}
	