package junq;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author : JunqWang
 * @Description: 和为S的两个数字
 * @Date: 10:01 2018/6/25
 **/

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7};
        int s = 8;
        ArrayList<Integer> result = findNumberWithSum(in, s);
        System.out.println(result.get(0) + "," + result.get(1));

        ArrayList<Integer> result2 = findNumberWithSum(in, s);
        System.out.println(result2.get(0) + "," + result2.get(1));
    }

    public static ArrayList<Integer> findNumberWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return arrayList;
        }
        int len = array.length;
        if (array[len - 1] + array[len - 2] < sum) {
            return arrayList;
        }
        for (int i = 0; i < len; i++) {
            int a = array[i];
            int b = sum - a;
            int j = i;
            while (array[j] < b) {
                j++;
            }
            if (array[j] == b) {
                if (arrayList == null || arrayList.size() == 0) {
                    arrayList.add(0, a);
                    arrayList.add(1, b);
                    arrayList.add(2, a * b);
                } else {
                    if (arrayList.get(2) > a * b) {
                        arrayList.add(0, a);
                        arrayList.add(1, b);
                        arrayList.add(2, a * b);
                    }
                }
            } else {
                continue;
            }
        }
        if (arrayList.size() > 0)
            arrayList.remove(2);
        return arrayList;
    }


    /*更优的解法*/
    public static ArrayList<Integer> findNumberWithSum2(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int curSum = array[i] + array[j];
            if (curSum == sum) {
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            }
            if (curSum < sum) {
                i++;
            }else{
                j--;
            }
        }
        return new ArrayList<>();
    }

}
