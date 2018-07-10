package junq;

import java.util.ArrayList;

/**
 * @Author : JunqWang
 * @Description: 和为S的连续正数序列
 * @Date: 14:57 2018/6/22
 **/

public class FindContinuousSequence {
    public static void main(String[] args) {
        int k = 100;
        ArrayList<ArrayList<Integer>> re = findContinuousSequence(k);
        System.out.println("以下为和为" + k + "的所有连续正数序列：");
        for (ArrayList<Integer> r : re) {
            for (Integer a : r) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {//至少是两个连续的正数，故而最小的和为3，如果小于3，那么就不会有合适的集合。
            return all;
        }
        int left = 1;//连续正整数序列的最左端
        int right = 2;//连续正整数序列的最右端
        int mid = (sum + 1) / 2;//去中间数，最左端一定小于中间数，最右端则一定大于中间数
        int cur_sum = left + right; //初始化当前序列的总和
        while (left < mid) {
            //若当前序列和大于要求，则把最左端向右移动
            while (cur_sum > sum && left < right) {
                cur_sum -= left;
                left++;
            }
            //当前序列和等于要求时，把该序列放入all中
            if (cur_sum == sum) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                addToList(item, left, right);
                all.add(item);
            }
            //若当前序列和小于要求，则把最右端向后移
            else {
                right++;
                cur_sum = cur_sum + right;
            }
        }
        return all;
    }


    private static void addToList(ArrayList<Integer> item, int left, int right) {
        for (int i = left; i <= right; i++) {
            item.add(i);
        }
    }
}
