package question11;

public class Power_junq {
    public static void main(String[] args) throws Exception {
        //主函数
        double result = power(-2.0,-3);
        System.out.println(result);

        double restult2 = power2(-3.0,5);
        System.out.println(restult2);
    }

    public static double power(double base,int exponent)throws Exception{
        //求指数函数
        double res =1.0; //double类型数据的初始化
        if(base == 0.0){
            throw new Exception("底数不能为0");
        }else if(exponent ==0){
            //非零底数的0次幂，结果为1
            return 1.0;
        }else if(exponent<0){
            //负指数幂
            int exp = -exponent;
            for(int i =0;i<exp;i++){
                res *= base;
            }
            return 1/res;
        }else{
            //正指数幂
            for(int j=0;j<exponent;j++){
                res *= base;
            }
            return res;
        }
    }

    public static double power2(double base,int exponent)throws Exception{
        double res = 1.0;
        if(base==0.0){
            throw new Exception("底数不能为0");
        }else if(exponent==0){
            return 1.0;
        }
        int n = exponent>0?exponent:(-exponent);
        res  =  power2(base,n>>1); //递归调用; 且正整数右移一位相当于除以2
        res *= res;
        if((n & 0x1)==1){
            res *= base;
        }
        res =(exponent>0) ? res : 1/res;
        return res;

    }
}
