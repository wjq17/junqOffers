package junq;
/**
* @Author : JunqWang
*
* @Description: 孩子们的游戏（圆圈中最后剩下的数）
*
* @Date: 9:19 2018/6/26
**/

public class LastRemaining_Solution {
    public static void main(String[] args) {

    }

    /*用一个数组保存是否出圈的状态，在圈内为1，出圈为0
    * 返回最后一个仍在圈内的数字
    */
    public static int lastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;  //这种情况下，返回-1
        int[] array = new int[n];
        int step =0;//记录走过的步数
        int count =n;//记录全中还剩下的人数
        int i =-1;
        while (count > 0) {
            i++;
            if (i >= n) i=0;//模拟环
            if(array[i]==-1) continue;//跳过被删除的对象
            step++;
            if (step == m) {
                array[i]=-1;
                step =0;
                count--;
            }
        }
        return i;
    }
}
