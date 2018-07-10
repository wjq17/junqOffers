package junq;

import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author : JunqWang
 * @Description: 连续子数组的最大和
 * @Date: 14:19 2018/6/12
 **/
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2}; //结果应该为8
        System.out.println(findGreatest(array));


        int[] array12 = new int[]{1, -2, 3, 10, -4, 7, 2, -5}; //结果应该为18
        System.out.println(findGreatest(array12));

        int[] a3 = new int[]{2, 8, 1, 5, 9}; //应该为25
        System.out.println(findGreatest(a3));

    }

    public static int findGreatest(int[] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0] <= 0)) return 0;
        int sum = array[0];  //累加求和
        int max = array[0];  //记录最大值
        for (int i = 1; i < array.length; i++) {
            sum = (sum > 0) ? (sum + array[i]) : array[i];
            max = Math.max(max, sum);
        }
        return max;
    }

}
