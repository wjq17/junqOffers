package junq;

import java.util.ArrayList;

/**
 * @Author : JunqWang
 * @Description: 数组中只出现一次的数字
 * @Date: 11:13 2018/6/22
 **/

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] in = new int[]{8, 1, 1, 5, 5, 8, 9, 6, 9, 6, 3, 7, 7, 4, 3, 15};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(in, num1, num2);
        System.out.println("思路一：ArrayList存储。 预期结果是4,15； 实际结果是；" + num1[0] + "," + num2[0]);

        int[] num11 = new int[1];
        int[] num12 = new int[1];
        findNumsAppearOnce2(in, num11, num12);
        System.out.println("思路二：位相与。        预期结果是4,15； 实际结果是；" + num11[0] + "," + num12[0]);
    }

    private static void findNumsAppearOnce2(int[] nums, int[] num11, int[] num12) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        // 得到最右一位
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num11[0] ^= num;
            else
                num12[0] ^= num;
        }
    }

    private static void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        ArrayList<Integer> once = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (once.contains(a)) {
                once.remove(once.indexOf(a));
            } else {
                once.add(a);
            }
        }
        num1[0] = once.get(0);
        num2[0] = once.get(1);
    }
}
