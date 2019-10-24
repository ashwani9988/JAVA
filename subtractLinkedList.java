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
