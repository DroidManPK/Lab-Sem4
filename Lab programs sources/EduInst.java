/*an edu institution wishes to maintain the database of its employees it is distributed among different classes, whose hirarchical relationship is as shown*/
import java.util.*;

class staff
{
	static int count;
	int id;
	double sal;
	String name;
	
	
	staff(int i,double s,String n)
{
	staff.count++;
	id=i;
	sal=s;
	name=n;
}
static String grader(double t,boolean f)
	{
		if(f)
		{if(t<60)
		return "C";
		if(t>60&&t<100)
		return "B";
		else 
		return "A";
		}
		else
		{
		if(t<5)
		return "C";
		if(t>5&&t<10)
		return "B";
		else 
		return "A";
		}
	}
public void update(double sa)
{
	sal=sa;
}
}

class teachstaff extends staff
{
	static int tc;
	String sub;
	int pub;
teachstaff(int id,double sal,String na,String s,int p)
{
	
	super(id,sal,na);
	sub=s;
	pub=p;
}

public void update(String s,int p)
{
	pub=p;
	sub=s;
	System.out.println("Enter the new Salary : ");
	super.update(EduInst.s.nextDouble());
}

}

class nonteach extends staff
{
	String g;
nonteach(int id,double s,String na,String g)
{
	super(id,s,na);
	this.g=g;
}

}

class typist extends nonteach
{
	double speed;
	typist(int id,double sa,String na,double s)
{
	super(id,sa,na,staff.grader(s,true));
	speed=s;
}

public void update(double p)
{
	speed=p;
	g=staff.grader(p,true);
	System.out.println("Enter the new Salary : ");
	super.update(EduInst.s.nextDouble());
}


}

class officer extends nonteach
{
	double year;
officer(int id,double sa,String na,double y)
{
	super(id,sa,na,staff.grader(y,false));
	year=y;
}

public void update(double y)
{
	year=y;
	g=staff.grader(year,false);
	System.out.println("Enter the new Salary : ");
	super.update(EduInst.s.nextDouble());
}
}


class EduInst
{
	static Scanner s= new Scanner(System.in);
	static int ind;
	static LinkedList<teachstaff> tea=new LinkedList<teachstaff>();
	static LinkedList<typist> typ=new LinkedList<typist>();
	static LinkedList<officer> ofr=new LinkedList<officer>();
	public static void main(String argp[])
{  
	String name,sub;
	int id,pub;
	double sal,sp,exp;      
       
        String dump;
while(true)
			{
			System.out.println("\n1 - Create entries\n2 - Update\n3 - Display Details on ID\n4 - Exit\nEnter your choice");
			
			switch(s.nextInt())
			{
			case 1:
while(true)
			{
				System.out.println("Enter the details of employee");
				System.out.print("\nName : ");
				dump=s.nextLine();
				name=s.nextLine();
				System.out.print("ID : ");
				id=s.nextInt();
				System.out.print("Salary : ");
				sal=s.nextDouble();
				System.out.println("1- Teaching staff\n2- Non teaching staff");
				switch(s.nextInt())
				{
					case 1: 
				System.out.print("\nSubject : ");
				dump=s.nextLine();
				sub=s.nextLine();
				System.out.print("Publications : ");
				pub=s.nextInt();
				teachstaff tk=new teachstaff(id,sal,name,sub,pub);
				tea.add(tk);
				break;
				
				case 2:System.out.println("1- Typist\n2- Officer");
				switch(s.nextInt())
				{
					case 1:System.out.println("Enter the speed of typist");
					sp=s.nextDouble();
					typist tj=new typist(id,sal,name,sp);
					typ.add(tj);
					break;
					case 2:
					System.out.println("Enter the year of Experience");
					exp=s.nextDouble();
					officer t=new officer(id,sal,name,exp);
					ofr.add(t);break;
					default:System.out.println("Invalid choice");
				}
				
			}
			System.out.println("Another Employee? yes-1 or no-0");
				if(s.nextInt()==0)break;
		}
		System.out.println("Teaching Staff : "+tea.size()+"\nNon teaching staff : "+(typ.size()+ofr.size())+"\nTypists count : "+typ.size()+"\nOfficers : "+ofr.size());
		break;
		
		case 3:
		System.out.println("Enter the id of the employee");
		switch(sea(s.nextInt()))
		{
		case 0:
		System.out.println("Employee not found");break;
		case 1:System.out.println("Employee is a Teaching Staff");
		System.out.println("\nName = "+tea.get(ind).name+"\nID = "+tea.get(ind).id+"\nSalary = "+tea.get(ind).sal+"\nSubject = "+tea.get(ind).sub+"\nPublications = "+tea.get(ind).pub);
		break;
		case 2:System.out.println("Employee is a non Teaching Staff and a typist");
		System.out.println("\nName = "+typ.get(ind).name+"\nID = "+typ.get(ind).id+"\nSalary = "+typ.get(ind).sal+"\nSpeed = "+typ.get(ind).speed+"\nGrade : "+typ.get(ind).g);
		break;
		case 3:System.out.println("Employee is a non Teaching Staff and a Officer");
		System.out.println("\nName = "+ofr.get(ind).name+"\nID = "+ofr.get(ind).id+"\nSalary = "+ofr.get(ind).sal+"\nExperience(years) = "+ofr.get(ind).year+"\nGrade : "+ofr.get(ind).g);
		break;}
		break;
		
		case 2:System.out.println("Enter the id of the employee");
		switch(sea(s.nextInt()))
		{
		case 0:
		System.out.println("Employee not found");break;
		case 1:System.out.println("Employee is a Teaching Staff");
		System.out.println("\nEnter the new Subject and Publications ");
		dump=s.nextLine();
		tea.get(ind).update(s.nextLine(),s.nextInt());
		break;
		case 2:System.out.println("Employee is a non Teaching Staff and a typist");
		System.out.println("\nEnter the new Speed = ");
		typ.get(ind).update(s.nextDouble());
		break;
		case 3:System.out.println("Employee is a non Teaching Staff and a Officer");
		System.out.println("\nEnter the Experience(years) = ");
		ofr.get(ind).update(s.nextDouble());
		break;
		}
		break;
		case 4:System.exit(0);
		default:System.out.println("Invalid choice");
}
}
}
		


static int sea(int id)
{
	for(int i=0;i<tea.size();i++)
	if(tea.get(i).id==id)
	{ind=i;return 1;}
	
	for(int i=0;i<typ.size();i++)
	if(typ.get(i).id==id)
	{ind=i;return 2;}
	
	for(int i=0;i<ofr.size();i++)
	if(ofr.get(i).id==id)
	{ind=i;return 3;}
	
	return 0;
}
}