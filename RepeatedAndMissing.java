import java.util.*;
public class RepeatedAndMissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Test Case");
		
		int t = sc.nextInt();
		
		
		
		while(t-- > 0) {
			
			System.out.println("Enter the Size of  the Array");
			
			int N = sc.nextInt();
			int ar[] = new int[N];
			System.out.println("Enter the Element in the Array");
			
			int repeating = 0  , missing = 0;
			
			
			boolean present[] = new boolean[N+1];
			for(int i=1; i<=present.length-1; i++) {
				present[i] = false;
			}
			
			
			for(int i=0 ; i<N ; ++i) {
				
				ar[i] = sc.nextInt();
				
				
				if(present[ar[i]] == true)
					repeating = ar[i];
				present[ar[i]] = true;
			}
			
			for(int i=1 ; i<N; i++) {
				if(present[i] == false)
					missing = i;
				
			}
			System.out.println("Repeating Element is:"+repeating); 
			System.out.print("Missing Element is :"+missing);
		}
		
	}

}
