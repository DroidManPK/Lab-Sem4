import java.util.*;

class book
{
		private String title;
		public static int count;
		public int code;
		private int quan;
		private double price;
		book(String t,int c,int q,double p)
		{
			title=t;
			code=c;
			quan=q;
			price=p;
			book.count++;
			System.out.println("Book registered");
		}
		public String toString()
		{
			return title+"\t"+code+"\t"+price+"\t\t"+quan+"\t\t"+(quan*price);
		}
		public String draw(int q)
		{
			if(quan-q>=0)
				{quan-=q;
					return "Amount to be paid = "+(q*price)+"\n";}
			else
				return "Book out of Stock\n";
		}
		public String dep(int q)
		{
			quan+=q;
			return "Added to stock\n";
		}

}

class Bookexe
{
		public static void main(String args[])
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the number of Books");			
			book[] b=new book[s.nextInt()];
			String dump=s.nextLine();
			String title;
			int code,quan;
			double price;
			while(true)
			{
			System.out.println("\n1 - Create book entries\n2 - Transactions\n3 - Display Stock\n4 - Exit\nEnter your choice");
			int ch=s.nextInt();
			switch(ch)
			{
			case 1:do
			{
				System.out.print("\nEnter the Details of the book\nTitle : ");
				dump=s.nextLine();
				title=s.nextLine();
				System.out.print("Code : ");
				code=s.nextInt();
				System.out.print("Quantity : ");
				quan=s.nextInt();
				System.out.print("Price : ");
				price=s.nextDouble();



				b[book.count]=new book(title,code,quan,price);
				
				
				System.out.println("Another book? yes-1 or no-0");
				if(s.nextInt()==0)break;
				else
					if(book.count==b.length)System.out.println("Books limit reached");

			}while(book.count<b.length);
			break;

			case 3:System.out.print("\nNAME\tCODE\tUNIT PRICE\tQUANTITY\tTOTAL PRICE\n");
			for(int i=0;i<book.count;i++)
			{
				System.out.println(b[i]);
			}
			break;

			case 2:System.out.println("\nTransactions : \n1 - Sell\n2 - Add to stock\n3 - Delete book from stock\nEnter your choice");
			int ch1=s.nextInt();
			book temp;
			boolean f=true;
			switch(ch1)
			{
				case 1:System.out.println("\nEnter the Details of the book");
						System.out.print("Code : ");
						code=s.nextInt();
						System.out.print("Quantity : ");
						quan=s.nextInt();
						for(int j=0;j<book.count;j++)
							{temp=b[j];
							if(code==temp.code)
								{f=false;System.out.println(temp.draw(quan));break;}
							}
							if(f)System.out.println("Book entry not found, please create it first");
						break;
				case 2:System.out.println("\nEnter the Details of the book");
						System.out.print("Code : ");
						code=s.nextInt();
						System.out.print("Quantity : ");
						quan=s.nextInt();
						for(int j=0;j<book.count;j++)
							{temp=b[j];
							if(code==temp.code)
								{f=false;System.out.println(temp.dep(quan));break;}}
							if(f)
								System.out.println("Book entry not found, please create it first");
							
						break;
				case 3:System.out.println("\nEnter the Details of the book");
						System.out.print("Code : ");
						code=s.nextInt();
						
						for(int j=0;j<book.count;j++)
						{temp=b[j];
							if(code==temp.code)
								{f=false;del(code,b);book.count--;System.out.println("Removed");break;}}
							if(f)
								System.out.println("Book entry not found, please create it first");
						break;
				default:System.out.println("Invalid choice");

			}break;
			case 4:System.exit(0);
			default:System.out.println("Invalid choice");
		}}
	}

	public static void del(int code,book[] b)	
	{int i,j;
		for (i = j = 0; j < book.count; ++j)
  							if (code!=b[j].code) b[i++] = b[j];
								b = Arrays.copyOf(b, i);
	}
}