import java.util.*;

class election
{
	public static void main(String arg[])
	{
		System.out.println("Enter the number of candidates");
		Scanner s=new Scanner(System.in);
		int inv=0,n=s.nextInt();
		cand[] c=new cand[n];
		String dump=s.nextLine();
		for(int i=0;i<n;i++)
		{System.out.println("Enter the candidate "+(i+1)+" name and party");
		c[i]=new cand();
		c[i].name=s.nextLine();
		c[i].party=s.nextLine();}
		
		System.out.println("Enter the number of ballets\n");
		int r=s.nextInt();
		for(int i=0;i<r;i++)
		{
			System.out.println("Enter ballet "+(i+1)+" votes, enter 999 to end the ballet");
			int t=s.nextInt();
			while(t!=999)
			{
				if(t<n)
				c[t-1].vote++;
				else
				inv++;
				t=s.nextInt();
			}
		}
		
		int max=c[0].vote,dex=0;
		for(int i=1;i<n;i++)
		if(c[i].vote>max)
		{max=c[i].vote;
		dex=i;
		}
		c[dex].win();
		System.out.println("Invalid votes : "+inv);
		}
		}
		
class cand
{
	public int vote;
	public String name,party;
	public void win()
	{
		System.out.println("Candidate "+name+" Of party "+party+" Won with votes "+vote);
	}
}
			