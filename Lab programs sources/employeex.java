import java.util.*;

class employee
{
	public static Scanner s=new Scanner(System.in);
	private int id;
	private String name,dept;
	private double bp,gp,np,it;
	public static int count;
	employee()
	{
		employee.count++;
	}
	public void getdata()
	{
		System.out.print("Enter the employee details :\nName : ");
		name=s.nextLine();
		System.out.print("ID : ");
		id=s.nextInt();
		System.out.print("Department : ");
		String dump=s.nextLine();
		dept=s.nextLine();
		System.out.print("Basic Pay : ");
		bp=s.nextDouble();
	}
	
	private void itax()
	{
		gp=bp+bp*0.58+bp*0.16;
	    if(bp<200000)
	    	it=0;
	    else if(gp<=300000)
	    	it=(gp-200000)*0.10;
	    else if(gp<=500000)
	    	it=10000+(gp-300000)*0.15;
	    else if(gp>500000)
	    	{it=40000+(gp-500000)*0.30;it+=(it*0.02);}
	    np=gp-it;
	}
	
	public String toString()
	{
	   itax();
	   return name+"\t"+id+"\t"+dept+"\t\t"+bp+"\t"+gp+"\t"+np;
	}
}


class employeex
{
    public static void main(String args[])
    {
    	System.out.println("Enter the number of Employees");
        employee[] e=new employee[employee.s.nextInt()];
       
        String dump=employee.s.nextLine();
        do
			{
				e[employee.count]=new employee();
				e[employee.count-1].getdata();
				
				
				System.out.println("Another Employee? yes-1 or no-0");
				if(employee.s.nextInt()==0)break;
				else
					if(employee.count==e.length)System.out.println("Employees limit reached");
				dump=employee.s.nextLine();

			}while(employee.count<e.length);
		
		System.out.println("NAME\tID\tDepartment\tBasic Pay\tGross Pay\tNet Pay");
		for(int i=0;i<employee.count;i++)
		{
			System.out.println(e[i]);
		}

    }
}