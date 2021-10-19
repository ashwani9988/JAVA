
import java.util.*;
class countwhitespace
{ 
    public static void main (String[] args) {
    Scanner S = new Scanner(System.in);
        String str = S.nextLine();
        int c = 0;
        for(int i = 0;i<str.length();i++)
         {
            if(str.charAt(i) == ' ')
            {
                c++;
            }
         }   
         System.out.println(c);
    }
    }

