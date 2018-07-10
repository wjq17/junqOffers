package junq;

import java.util.Scanner;

/**
* @Author : JunqWang
*
* @Description: 丑数
*
* @Date: 16:02 2018/6/13
**/
public class GetUglyNumber {
    public static void main(String[] args) {
        System.out.println("请在如下输入n的值，您将会获得第n个丑数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getUgly(n));
    }

    private static int getUgly(int index) {
        if(index<=6) return index;
        int i2 =0,i3=0,i5=0; //相当于指针，指向哪个数代表它前面的已经乘以过2/3/5了
        int[] dp = new int[index];
        dp[0]=1;
        for(int i=1;i<index;i++) {
            dp[i] = Math.min(dp[i2]*2,Math.min(dp[i3]*3,dp[i5]*5));//其中最小的为下一个丑数
            //把已经存在的数，往前移动一下
            if(dp[i]==dp[i2]*2) i2++;
            if(dp[i]==dp[i3]*3) i3++;
            if(dp[i]==dp[i5]*5) i5++;
        }
        return dp[index - 1];
    }


}
