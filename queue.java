import java.util.Stack; 
  
public class GFG { 
   
    static class Queue { 
        Stack<Integer> stack1; 
        Stack<Integer> stack2; 
    } 
  
   
    static void push(Stack<Integer> top_ref, int new_data) 
    { 
     
        top_ref.push(new_data); 
    } 
  
   
    static int pop(Stack<Integer> top_ref) 
    { 
       
        if (top_ref.isEmpty()) { 
            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 
  
       
        return top_ref.pop(); 
    } 
  
   
    static void enQueue(Queue q, int x) 
    { 
        push(q.stack1, x); 
    } 
  
   
    static int deQueue(Queue q) 
    { 
        int x; 
  
       
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) { 
            System.out.println("Q is empty"); 
            System.exit(0); 
        } 
  
        
      
        if (q.stack2.isEmpty()) { 
            while (!q.stack1.isEmpty()) { 
                x = pop(q.stack1); 
                push(q.stack2, x); 
            } 
        } 
        x = pop(q.stack2); 
        return x; 
    } 
  
   
    public static void main(String args[]) 
    { 
       
        Queue q = new Queue(); 
        q.stack1 = new Stack<>(); 
        q.stack2 = new Stack<>(); 
        enQueue(q, 1); 
        enQueue(q, 2); 
        enQueue(q, 3); 
  
       
        System.out.print(deQueue(q) + " "); 
        System.out.print(deQueue(q) + " "); 
        System.out.println(deQueue(q) + " "); 
    } 
} 
