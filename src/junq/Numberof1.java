package junq;
/**
* @Author : JunqWang
*
* @Description: 整数中1出现的次数（从1到n整数中1出现的次数）
*
* @Date: 15:36 2018/6/12
**/

public class Numberof1 {
    public static void main(String[] args) {
        int a  = 13; //6
        System.out.println(solution(a));

    }

    public static int solution(int n) {
        if(n<=0) return 0;
        int sum  =0;
        for(int i=1;i<=n;i++) {
            char[] cs = String.valueOf(i).toCharArray();
            for (char c : cs) {
                if (c - '1' == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
