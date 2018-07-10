package question09;

/* 
 *  
 * f(n)=0, n=0 
 * fn=1,n=1 
 * fn=fn-1 + fn-2   n>=2 
 */  
public class Fibonacci {  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int n=4;  
          
        int sum=fibonacci(n);  
        System.out.println(sum);  
          
    }  
  
    private static int fibonacci(int n) {  
        // TODO Auto-generated method stub  
        if (n<0) {  
            return -1;  
        }  
        if (n==0||n==1) {  
            return n;  
        }  
          
        int fnSub2=0;  
        int fnSub1=1;  
        int fn = 0;  
        for (int i = 2;  i<=n; i++) {  
            fn=fnSub1+fnSub2;  
              
            fnSub2=fnSub1;    //注意这两部不能写反，不然会出错  
            fnSub1=fn;  
        }  
        return fn;  
    }  
  
}  