package junq;

import java.util.HashMap;
import java.util.Scanner;

/**
* @Author : JunqWang
*
* @Description: 数组中出现次数超过一半的数字
*
* @Date: 9:19 2018/6/11
**/

public class MoreThanHalfNum_Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] c = s.toCharArray();
        int[] a = new int[c.length];
        for(int i=0;i<c.length;i++) {
            a[i] = c[i] - '0';//'0'是零
        }
        int result = morethanhalfnum(a);
        System.out.println(result);

    }

    public static int morethanhalfnum(int[] array){
        if(array==null || array.length==0)return 0;
        if (array.length == 1 || array.length==2) {
            return array[0];
        }
        int halflen = array.length /2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.get(i) != null) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > halflen) {
                    return i;
                }
            }else{
                map.put(i, 1);
            }
        }

        return 0; //如果不存在，就输出0
    }
}
