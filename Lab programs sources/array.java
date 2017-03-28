import java.util.*;

class array
{
	public static void main(String arg[])
	{
	System.out.println("Enter the number of elements in array A");
	Scanner s=new Scanner(System.in);
	QuickSort sorter = new QuickSort();
	int[] A=new int[s.nextInt()];
	System.out.println("Enter the elements of Array A : ");
	for(int i=0;i<A.length;i++)
	A[i]=s.nextInt();

	System.out.println("Enter the number of elements in array B");
	int[] B=new int[s.nextInt()];
	System.out.println("Enter the elements of Array B : ");
	for(int i=0;i<B.length;i++)
	B[i]=s.nextInt();
	int[] C=new int[A.length+B.length];
	for(int i=0;i<A.length;i++)
	C[i]=A[i];
	for(int i=A.length;i<C.length;i++)
	C[i]=B[i-A.length];
	sorter.sort(C);
	System.out.println("Sorted Array C :");
	for(int i=0;i<C.length;i++)
	System.out.println(C[i]);
	}	
}

class QuickSort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            //Scan from left and right and exchange
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    }
    
