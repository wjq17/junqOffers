package question11;

public class Power {  
    
    static boolean valid=true;  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    double res=   power(2.0,-2);  
    System.out.println(res);  
    }  
    private static double power(double base, int exponent) {  
          
        if (eaqual(base,0.0)) {  //考虑底数为 0 ，计算机中判断两个小数是否相等不能用== 必须用差的绝对值小于一个参考值  
            valid=false;        // 区别 返回0的情况  
            return 0.0;  
        }  
          
        if (exponent==0) {  
            return 1;  
        }  
        if (exponent==1) {  
            return base;  
        }  
        int absExponent=Math.abs(exponent);  
          
        double res=power(base, absExponent>>1);  
          
        res*=res;  
        if ((absExponent&1)==1) {   //absExponent 为 奇数   
            res=res*base;        
        }  
        if (exponent<0) {         //absExponent 为 负数   
            res=1/res;  
        }  
        return res;  
          
    }  
      
    private static boolean eaqual(double base, double d) {  
        // TODO Auto-generated method stub  
        if (Math.abs(base-d)<0.0001) {  
            return true;  
        }  
          
        return false;  
    }  
  
}  