package junq;

import java.util.HashMap;

/**
 * @Author : JunqWang
 * @Description: 数字在排序数组中出现的次数
 * @Date: 11:26 2018/6/20
 **/

public class GetNumnerOfK {
    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 2, 4, 5, 5, 6, 8, 8, 8, 9, 45, 48, 49, 99, 99};
        int k = 99;
        System.out.println("思路一：预期为2，结果为：" + getNumnerOfK(in, k));
        System.out.println("思路二：预期为2，结果为：" + getNumnerOfK2(in, k));


        int[] in2 = new int[]{1, 3, 3, 3, 3, 4, 5};
        int k2 = 2;
        System.out.println("思路一：预期为0，结果为：" + getNumnerOfK(in2, k2));
        System.out.println("思路二：预期为0，结果为：" + getNumnerOfK2(in2, k2));
    }

    /*思路二：二分查找*/
    public static int getNumnerOfK2(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        if (k < array[0]) return 0;
        int first = binarySearch(array, k);
        int last = binarySearch(array,k+1);
        return (first==array.length || array[first]!=k)?0:last-first;
    }

    /*二分查找算法 --  输入数组中该数值的第一个位置*/
    public static int binarySearch(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int getNumnerOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        if (map.get(k) != null) {
            result = map.get(k);
        }
        return result;
    }
}
