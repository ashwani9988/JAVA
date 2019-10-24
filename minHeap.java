package heap;

import java.util.Scanner;

public class MinHeap {

    public static void minHeap(int[] arr,int i)
    {
      int childIndex=i;
      int parentIndex=(childIndex-1)/2;
      while (childIndex>0)
      {
          if(arr[childIndex]<arr[parentIndex])
          {
              int temp=arr[childIndex];
              arr[childIndex]=arr[parentIndex];
              arr[parentIndex]=temp;
              childIndex=parentIndex;
              parentIndex=(childIndex-1)/2;
          }
          else
              return;
      }
    }
    public static void print(int [] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int arr[]= {5,3,17,10,84,19,6,22,9};

    print(arr);
  for(int i=0;i<arr.length;i++)
  {
      System.out.println(arr[i]);
      minHeap(arr,i);
  }
    System.out.println();
  print(arr);
}
}
