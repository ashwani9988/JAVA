package Queue;

import java.util.Stack;

public class QueueWithStack {
Stack<Integer> s1=new Stack<Integer>();
Stack<Integer> s2=new Stack<Integer>();
public void enqueue(int value)
{
    s1.push(value);
}
public int dequeue()
{
    if(s1.isEmpty() && s2.isEmpty())
    {
        System.out.println("queue is empty");
         System.exit(0);
    }
    else if(s2.isEmpty())
    {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
    }
      return s2.pop();
}
public static void main(String[] args)
{
    //comment
    QueueWithStack queueWithStack=new QueueWithStack();
    queueWithStack.enqueue(1);
    queueWithStack.enqueue(2);
    queueWithStack.enqueue(3);
    System.out.println(queueWithStack.dequeue());
    System.out.println(queueWithStack.dequeue());
    System.out.println(queueWithStack.dequeue());
}
}
