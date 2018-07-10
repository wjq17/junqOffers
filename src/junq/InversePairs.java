package junq;

import java.util.Arrays;

/**
 * @Author : JunqWang
 * @Description: 数组中的逆序对
 * @Date: 16:16 2018/6/19
 **/



public class InversePairs {

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7, 0}; //应当是7
        int result = inversePairs(in);
        System.out.println(result);
    }
    private static long cnt = 0;
    private static int[] tmp; // 在这里创建辅助数组，而不是在 merge() 递归函数中创建

    public static int inversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private static void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private static void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] < nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                cnt += m - i + 1; // a[i] > a[j]，说明 a[i...mid] 都大于 a[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }
}


/*您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。*/
//    private static int inversePaire(int[] array) {
//        if (array == null || array.length == 0) return 0;
//        long result = 0;
//        for(int i=0;i<array.length-1;i++) {
//            for(int j=i+1;j<array.length;j++) {
//                if(array[i]>array[j]) result ++;
//            }
//        }
//        //取模，即：求余数
//        return (int) result % 1000000007;
//    }
