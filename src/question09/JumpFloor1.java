package question09;

import java.util.Scanner;  

public class JumpFloor1 {  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner in = new Scanner(System.in);  
  
        while (in.hasNextInt()) {  
            int n = in.nextInt();  
            System.out.println(JumpFloor(n));  
        }  
  
    }  
  
    public static int JumpFloor(int number) {  
        if (number == 1 || number == 2) {  
            return number;  
        }  
  
        int jumpFib = 0;  
        int NumberMinusOne = 2;  
        int NumberMinusTwo = 1;  
        for (int i = 3; i <= number; i++) {  
            jumpFib = NumberMinusOne + NumberMinusTwo;  
            NumberMinusTwo = NumberMinusOne;  
            NumberMinusOne = jumpFib;  
  
        }  
        return jumpFib;  
    }  
}  
