package question45;

import java.util.Arrays;
import java.util.LinkedList;

public class LastNumbersInCircle {
	 public static int LastRemaining_Solution(int n, int m) {
		 if (n<1||m<1) {
			return -1;
		}
		int last=0;
		for (int i = 2; i <=n; i++) {
			last=(last+m)%i;
		}
		return last;
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int res=LastRemaining_Solution(5, 3);
        
         System.out.println(res);
        
      
		
	}


}
