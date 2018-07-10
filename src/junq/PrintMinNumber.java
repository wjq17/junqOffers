package junq;

import java.util.ArrayList;

/**
 * @Author : JunqWang
 * @Description: 把数组排列成最小的数
 * @Date: 14:37 2018/6/13
 **/

public class PrintMinNumber {

    public static void main(String[] args) {
        int[] array = new int[]{3, 32, 321}; //最小数字为321323
        System.out.println(PrintMinNumber(array));

    }

    public static String  PrintMinNumber(int[] numbers) {
        String min = new String();
        if (numbers == null || numbers.length == 0) {
            return min;
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }
        int len = numbers.length;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                String a = numbers[i] + "" + numbers[j];
                String b = numbers[j] + "" + numbers[i];
                if (a.compareTo(b)>0) { //大于0，则a大于b,交换i,j
                    swap(i, j, numbers);
                }
            }
        }
        for (int num : numbers) {
            min += String.valueOf(num);
        }
        return min;
    }

    private static void swap(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j]= temp;
    }

}
