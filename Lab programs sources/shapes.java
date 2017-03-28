//rectangle, triangle, circle, square, cube, cuboids and cylinder by pavan

import java.util.*;

class shape
{
    void area(float x)
    {
        System.out.println("The area of the square is "+Math.pow(x, 2)+" sq units");
    }
    void area(float x, float y)
    {
        System.out.println("The area of the rectangle is "+x*y+" sq units");
    }
    void area(double x)
    {
        double z = 3.14 * x * x;
        System.out.println("The area of the circle is "+z+" sq units");
    }
    void area(float x,float y,float z)
    {
        double s4 = (x + y + z )/ 2 ;
        double area = Math.sqrt(s4 * (s4 - x) * (s4 - y) * (s4 - z));
        System.out.print("Area of Triangle is :"+area+" sq units");
    }
    void sarea(double side)
    {
        System.out.print("Surface Area of cube is :"+(6 * side * side)+" sq units");
        System.out.println("Volume Of the Cube is : "+(side*side*side)+" cubic units");
    }
    void sarea(double len,double wid,double he)
    {
        System.out.print("Surface Area of Cuboid is :"+(2 * (len * wid + len * he + wid * he))+" sq units");
        System.out.println("Volume Of the Cuboid is : "+(len * wid * he)+" cubic units");
        System.out.print("Lateral Surface Area of Cuboid is :"+(2 * he * (len + wid))+" sq units");
    }
    void sarea(double r,double h)
    {
        double p=3.141592654;
        System.out.println("Surface Area of Cylinder is :"+(2*p*r*h+2*p*r*r)+" sq units");
        System.out.println("Volume Of the Cylinder is : "+(p*r*r*h)+" cubic units");
    }
}


class shapes 
{
     public static void main(String args[]) 
	{
	   Scanner s=new Scanner(System.in);
       shape a=new shape();
       while(true)
       {
         System.out.println("1 - Square\n2 - Rectangle\n3 - Triangle\n4 - Circle\n5 - Cube\n6 - Cuboid\n7 - Cylinder\n8 - Exit\nEnter your Choice : ");
         int ch=s.nextInt();
         switch(ch)
         {
                case 1:System.out.print("Enter the Side of the Square : ");
                        a.area(s.nextFloat());break;
                case 2:System.out.print("Enter the Sides of the Rectangle : ");
                        a.area(s.nextFloat(),s.nextFloat());break;
                case 3:System.out.print("Enter the Sides of the Triangle : ");
                        a.area(s.nextFloat(),s.nextFloat(),s.nextFloat());break;
                case 4:System.out.print("Enter the Radius of the Circle : ");
                        a.area(s.nextDouble());break;
                case 5:System.out.print("Enter the Radius of the Cube : ");
                        a.sarea(s.nextDouble());break;
                case 6:System.out.println("Enter the Length, Width and Height of Cuboid");
                        a.sarea(s.nextDouble(),s.nextDouble(),s.nextDouble());break;
                case 7:System.out.println("Enter the Radius and Height of the Cylinder");
                        a.sarea(s.nextDouble(),s.nextDouble());break;
                case 8:System.exit(0);
                default:System.out.println("Invalid choice");
         }
       }
    }
}