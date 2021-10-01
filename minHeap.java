
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
    //comment
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
public class MinHeap { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    private static final int FRONT = 1; 
  
    public MinHeap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MIN_VALUE; 
    } 
  
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
  
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
  
   
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
   
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
   
    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
   
    private void minHeapify(int pos) 
    { 
  
     
        if (!isLeaf(pos)) { 
            if (Heap[pos] > Heap[leftChild(pos)] 
                || Heap[pos] > Heap[rightChild(pos)]) { 
  
                // Swap with the left child and heapify 
                // the left child 
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
                    swap(pos, leftChild(pos)); 
                    minHeapify(leftChild(pos)); 
                } 
  
               
                else { 
                    swap(pos, rightChild(pos)); 
                    minHeapify(rightChild(pos)); 
                } 
            } 
        } 
    } 
  
   
    public void insert(int element) 
    { 
        if (size >= maxsize) { 
            return; 
        } 
        Heap[++size] = element; 
        int current = size; 
  
        while (Heap[current] < Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
 
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] 
                             + " LEFT CHILD : " + Heap[2 * i] 
                             + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    
    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
  
  
    public int remove() 
    { 
        int popped = Heap[FRONT]; 
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT); 
        return popped; 
    } 
  
  
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
  
        minHeap.print(); 
        System.out.println("The Min val is " + minHeap.remove()); 
    } 
} 
