
package LinkedListQues;
public class SubtractLinkedList {
    public static boolean getBig(Node a,Node b)
    {
        boolean check=false;
        while(a!=null)
        {
            if(a.data>b.data)
            {
                check=false;
            }
            else {check=true;
            break;}
        a=a.nextRef;
            b=b.nextRef;
        }
        return check;
    }
public static LinkedList subtract(LinkedList list1, LinkedList list2)
{
    LinkedList res= new LinkedList();
    Node first=list1.head;
    Node second=list2.head;
    int count1=0,count2=0;
    while(first!=null)
    {
        first=first.nextRef;
        count1++;
    }
    while(second!=null)
    {
        second=second.nextRef;
        count2++;
    }
    first=list1.head;
    second=list2.head;
    if(count1<count2)
    {
        Node t=first;
        first=second;
        second=t;
    }
    else if(count1==count2)
    {
      if(getBig(first,second))
      {
          Node t=first;
          first=second;
          second=t;
      }
      else
      {

      }
    }
    list1.head=first;
    list2.head=second;
    list1.reverse();
    list2.reverse();
    boolean borrow=false;
   int ans=0;
    first=list1.head;
    second=list2.head;

    while(first!=null || second!=null)
    {
        if(borrow)
        {
            first.data=first.data-1;
            borrow=false;
        }
        if(second != null)
        {
            if(first.data<second.data)
            {
                first.data=first.data+10;
                borrow=true;
            }
            else
            {
                borrow=false;
            }
            if(first!=null && second!=null)
            {
                ans=first.data-second.data;
                res.insertAtStart(ans);
            }
            second=second.nextRef;
        }
        else {
            ans=first.data-0;
            res.insertAtStart(ans);
        }

        first=first.nextRef;


    }
   return res;
}
    public static void main(String[] args) {
    LinkedList list= new LinkedList();
        LinkedList list1 = new LinkedList();
        list.insertAtLast(7);
        list.insertAtLast(0);
        list.insertAtLast(1);
        list1.insertAtLast(1);
        list1.insertAtLast(9);
//        list1.insertAtLast(7);
        LinkedList res=subtract(list, list1);
       res.show();

    }
}
=======
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class LinkedList 
{ 
    static Node head; 
    boolean borrow; 
  
   
    static class Node { 
        int data; 
        Node next; 
          
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
   
    int getLength(Node node)  
    { 
        int size = 0; 
        while (node != null) 
        { 
            node = node.next; 
            size++; 
        } 
        return size; 
    } 
  
   
    Node paddZeros(Node sNode, int diff) 
    { 
        if (sNode == null) 
            return null; 
  
        Node zHead = new Node(0); 
        diff--; 
        Node temp = zHead; 
        while ((diff--) != 0) 
        { 
            temp.next = new Node(0); 
            temp = temp.next; 
        } 
        temp.next = sNode; 
        return zHead; 
    } 
  
   
    Node subtractLinkedListHelper(Node l1, Node l2) 
    { 
        if (l1 == null && l2 == null && borrow == false) 
            return null; 
  
        Node previous = subtractLinkedListHelper((l1 != null) ?  
                                 l1.next : null, (l2 != null) ?  
                                 l2.next : null); 
  
        int d1 = l1.data; 
        int d2 = l2.data; 
        int sub = 0; 
  
       
        if (borrow) 
        { 
            d1--; 
            borrow = false; 
        } 
  
       
        if (d1 < d2) 
        { 
            borrow = true; 
            d1 = d1 + 10; 
        } 
  
       
        sub = d1 - d2; 
  
       
        Node current = new Node(sub); 
  
      
        current.next = previous; 
  
        return current; 
    } 
  
   
    Node subtractLinkedList(Node l1, Node l2) 
    { 
        // Base Case. 
        if (l1 == null && l2 == null) 
            return null; 
  
        
        int len1 = getLength(l1); 
        int len2 = getLength(l2); 
  
        Node lNode = null, sNode = null; 
  
        Node temp1 = l1; 
        Node temp2 = l2; 
  
       
        if (len1 != len2) 
        { 
            lNode = len1 > len2 ? l1 : l2; 
            sNode = len1 > len2 ? l2 : l1; 
            sNode = paddZeros(sNode, Math.abs(len1 - len2)); 
        } 
  
        else
        { 
          
            while (l1 != null && l2 != null) 
            { 
                if (l1.data != l2.data) 
                { 
                    lNode = l1.data > l2.data ? temp1 : temp2; 
                    sNode = l1.data > l2.data ? temp2 : temp1; 
                    break; 
                } 
                l1 = l1.next; 
                l2 = l2.next; 
            } 
        } 
  
       
        borrow = false; 
        return subtractLinkedListHelper(lNode, sNode); 
    } 
  
   
    static void printList(Node head) 
    { 
        Node temp = head; 
        while (temp != null)  
        { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
    } 
  
   
    public static void main (String[] args)  
    { 
        Node head = new Node(1); 
        head.next = new Node(0); 
        head.next.next = new Node(0); 
  
        Node head2 = new Node(1); 
          
        LinkedList ob = new LinkedList(); 
        Node result = ob.subtractLinkedList(head, head2); 
  
        printList(result); 
  
    }  
} 
