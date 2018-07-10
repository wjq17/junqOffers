package question42;

public class LoopMove {  
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	String str="abcdefg";
    	char arr[]=str.toCharArray();
       
        int n = arr.length, k = 2;  
        RightShift(arr, n, n-k);  
        for (int i = 0; i < arr.length; i++) {  
            System.out.print (arr[i]+" ");  
        }  
    }  
  
    private static void RightShift(char[] arr, int n, int k) {  
        // TODO Auto-generated method stub  
        k %= n;  
        Reverse(arr, 0, n - k - 1);          
        Reverse(arr, n - k, n - 1);  
        Reverse(arr, 0, n - 1);  
    }  
  
    private static void Reverse(char[] arr, int i, int j) {  
        // TODO Auto-generated method stub  
        for (; i < j; i++, j--) {  
            char temp = arr[i];  
            arr[i] = arr[j];  
            arr[j] = temp;  
        }  
    }  
  
}  