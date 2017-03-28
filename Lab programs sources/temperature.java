import java.util.*;

class temperature
{
    public static void main(String args[])
    {
            Scanner s=new Scanner(System.in);
			System.out.println("enter the number of cities");
			int n=s.nextInt();
			String dump=s.nextLine();
            double ma[]=new double[n];
            double mi[]=new double[n];
            
            city[] c=new city[n];
            for(int i = 0; i < n; i++)
            {c[i]=new city();
            System.out.println("enter the name of city");
            c[i].name=s.nextLine();
            System.out.println("enter the temps of 7 days");
            c[i].read();
            }
            
			System.out.print("\n"+"City\t"+"Day1\tDay2\tDay3\tDay4\tDay5\tDay6\tDay7\n");
            for(int i = 0; i < n; i++)
            {
                    
                    System.out.print("\n"+c[i].name);
                    c[i].printt();
            }
			
            for(int i = 0; i < n; i++)
			{c[i].sort();
            ma[i]=c[i].max();
            mi[i]=c[i].min();}
			
            System.out.println("\n\n");
			maxer(ma,c);
            System.out.println("\n\n");
            minner(mi,c);
			System.out.println("Press any key to exit");
            dump=s.nextLine();
            }
                    
            public static void maxer(double a[],city[] c)
            {
				Arrays.sort(a);
				double max=a[(a.length)-1];
                   for(int i=0;i<a.length;i++)
					   for(int j=0;j<7;j++)
						   if(c[i].temp[j]==max)
							   System.out.println("City with maximum temperature : "+c[i].name+"  on Day : "+c[i].mad+"\n");
          
          
          }
          
           public static void minner(double a[],city[] c)
            {
				Arrays.sort(a);
				double min=a[0];
                   for(int i=0;i<a.length;i++)
					   for(int j=0;j<7;j++)
						   if(c[i].temp[j]==min)
							   System.out.println("City with minimum temperature : "+c[i].name+"  on Day : "+c[i].mid+"\n");
          
          
          }
          
                    
}
            
    
class city
{
    public String name;
    public double temp[]=new double[7];
	public double dup[]=new double[7];
	public int mad,mid;
    
    public void read()
    {
            Scanner s=new Scanner(System.in);
            for(int j=0;j<7;j++)
            {temp[j]=s.nextDouble();dup[j]=temp[j];}
    }
    public void printt()
    {
            for(int j=0;j<7;j++)
                    System.out.print("\t"+temp[j]);
            }
            
    public void sort()
    {
            Arrays.sort(temp);
	}
          
          public double max()
          {for(int i=0;i<7;i++)
			  if(dup[i]==temp[6])
				  mad=i+1;
          
          return temp[6];}
          
          public double min()
          {	for(int i=0;i<7;i++)
			  if(dup[i]==temp[0])
				  mid=i+1;
			  
          return temp[0];}
         }