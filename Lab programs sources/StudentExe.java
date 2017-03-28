import java.util.*;

class Student {
	int rollno,total;
	int smark[] = new int[3];
	void getdata() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the roll number:");
		rollno = in.nextInt();
		total = 0;
		for(int i = 0;i<3;i++) {
			System.out.println("Enter subject "+(i+1)+"marks: ");
			smark[i] = in.nextInt();
			total = total+smark[i];
		}
	}
	
	void display() {
		System.out.println(rollno+"\t\t"+smark[0]+"\t\t"+smark[1]+"\t\t"+smark[2]+"\t\t"+total);
	}
	
	int getmarks(int n) {
		return smark[n] ;
	}
}

class StudentExe {
	public static void main(String args[]) {
		Student stu[] = new Student[20] ; 
		
		System.out.println("Enter the number of students: ");
		Scanner inp= new Scanner(System.in);
		int n = inp.nextInt();
		for(int i=0;i<n;i++) {
			stu[i] = new Student();
			stu[i].getdata();
		}
		
		System.out.println("Student details:\nRoll no\t\tSubject1\tSubject2\tSubject3\tTotal");
		for(int i = 0;i<n;i++) 
			stu[i].display();
		
		int max;
		int index;
		for(int i=0;i<3;i++) {
			index=0;
			max= stu[0].getmarks(i);
			
			for(int j = 1;j<n;j++) 
				if(max<stu[j].getmarks(i)) {
					index=j;
					max = stu[j].getmarks(i);
				}
			System.out.println("Maximum marks in subject "+(i+1));
			System.out.println("Roll Number: "+stu[index].rollno);
			System.out.println("Marks: "+max+"\n");
			
		}
		
		int maxt = stu[0].total;		
		int ind=0;
		for(int i=1;i<n;i++) 
			if(maxt<stu[i].total) {
				maxt = stu[i].total;
				ind = i;
			}
		System.out.println("Maximum total marks : "+maxt+"\nRoll Number: "+stu[ind].rollno);
	}
}