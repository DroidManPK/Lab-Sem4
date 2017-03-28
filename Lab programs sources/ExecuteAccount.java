import java.util.*;
class Account {
	public static int count;
	private int no;
	String name = new String();
	private String type;
	private double balance;
	
	public Account() {
		Account.count++;
		this.balance = 0;
	}
	void getdata() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the name, number ,type:");
		name = in.nextLine();
		no = in.nextInt();
		String dump=in.nextLine();
		type = in.nextLine();
	}
	void deposit(double amount) {
		balance+=amount;
	}
	void draw(double amount) {
		if((balance<amount)||((type=="s")&&((balance-amount)<1000))||((type=="c")&&((balance-amount)<500)))
			System.out.println("Insufficient balance");
		else
			balance-=amount;
	}
	void display() {
		System.out.println("Name : "+name+"\nBalance : "+balance);
	}
	boolean checknumber(int num) {
		if(num==no)
			return true;
		else 
			return false;
	}
}
class ExecuteAccount {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String dump;
		int i=0,j;
		System.out.println("Enter the number of accounts");
		int cou=in.nextInt();
		Account a[] = new Account[cou];
		while(true) {
			System.out.println("1.Create Account\n2.Deposit\n3.Withdraw\n4.Display\n5.Total number of accounts created\n6.Exit\nEnter your choice");
			int ch = in.nextInt();
			switch(ch) {
				case 1: if(i<cou)
						{a[i] = new Account();
						a[i].getdata();
						i++;}
						else
							System.out.println("Accounts limit reached");
						break;
				case 2: System.out.println("Enter your account number");
						int n = in.nextInt();
						for(j=0;j<=i;j++){
						
							if(a[j].checknumber(n))
								break;}
						if(!a[j].checknumber(n)) 
							System.out.println("Invalid account number");
						else {
							System.out.println("Enter the amount:");
							
							a[j].deposit(in.nextDouble());
							}
						
						break;
				case 3:	System.out.println("Enter your account number");
						int nu = in.nextInt();
						for(j=0;j<=i;j++){
											 
							if(a[j].checknumber(nu))
								break;}
						if(!a[j].checknumber(nu)) 
							System.out.println("Invalid account number");
						else {
							System.out.println("Enter the amount:");
							
							a[j].draw(in.nextDouble());
							}
						
						break;
				case 4:	System.out.println("Enter your account number");
						int ni = in.nextInt();
						for(j=0;j<=i;j++)
						{						 
							if(a[j].checknumber(ni))
								break;}
						if(!a[j].checknumber(ni)) 
							System.out.println("Invalid account number");
						else
							a[j].display();
						
						break;
				case 5:System.out.println("Total number of accounts created is "+Account.count);break;
				case 6:System.exit(0);
				default : System.out.println("Invalid choice");
			}
		}
	}
}	
			