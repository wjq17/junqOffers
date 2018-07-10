package junq;

import java.util.ArrayList;
import java.util.Scanner;

/**
* @Description:    最小的K个数
* @Author:         junqWang
* @CreateDate:     2018/6/11 15:55
* @UpdateUser:     junqWang
* @UpdateDate:     2018/6/11 15:55
* @UpdateRemark:   修改内容
* @Version:        1.0
*/


public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int k=Integer.parseInt(scanner.nextLine());
        char[] s  = in.toCharArray();
        int[] a = new int[s.length];
        for (int i=0;i<a.length;i++) {
            a[i] = (int) s[i];
        }
        ArrayList<Integer> result = GetLeastNumbers(a, k);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> leastk = new ArrayList<Integer>();
        if(input==null || input.length==0 || input.length<k) return leastk;
        for(int i =0;i<k;i++) {
            //冒泡排序，每次排序过程确定一个最小值
            for(int j = input.length-1;j>i;j--){
                if (input[j - 1] > input[j]) { //交换，把小的顶到前面去
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1]= temp;
                }
            }
            leastk.add(input[i]);
        }
        return leastk;
    }
}
