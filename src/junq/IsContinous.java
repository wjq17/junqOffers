package junq;


import java.util.Arrays;

/**
 * @Author : JunqWang
 * @Description: 扑克牌顺子
 * @Date: 16:54 2018/6/25
 **/

public class IsContinous {
    public static void main(String[] args) {
        int[] in = new int[]{1,3,2,5,4};
        System.out.println(isContinuous(in));
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int cnt = 0;
        for (int num : numbers) {
            if (num == 0) {
                cnt++;
            }
        }
        int ksum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int a = numbers[i];
            int b = numbers[i + 1];
            if (a == 0 || b == 0) {
                continue;
            }
            if (b == a) {
                return false;
            }
            ksum += b - a - 1;
        }
        if ((cnt != 0 && ksum == cnt)||ksum ==0) {
            return true;
        }
        return false;
    }
}
