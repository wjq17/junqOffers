package junq;

/*
* 调整数组顺序，让奇数位于偶数前面
* 要保证奇偶内部的相对顺序不变
*/

import java.util.ArrayList;

public class AdjustTheArrayOrder {
    public static void main(String[] args){
        int[] in = new int[]{1,2,3,4,5,6,7};
        //方法一
        ArrayList<Integer> out = AdjustArray(in);
        for(int i=0;i<out.size();i++){
            System.out.print(out.get(i)+" ");
        }


        //方法二
        int[] out2 = AdjustArray2(in);
        for(int i=0;i<out2.length;i++){
            System.out.print(out2[i]+" ");
        }

    }

    private static int[] AdjustArray2(int[] array) {
        int[] copy = array.clone();
        //统计原数组中奇数的个数
        int oddcount = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1)
                oddcount++;
        }
        //将数组重新排列
        int odd =0;
        for(int j=0;j<copy.length;j++){
            if(copy[j]%2==0){
                array[oddcount]=copy[j];
                oddcount++;
            }else{
                array[odd]=copy[j];
                odd++;
            }
        }
        return array;
    }

    private static ArrayList<Integer> AdjustArray(int[] in) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i =0;i<in.length;i++){
            int value = in[i];
            if(value%2==0){
                even.add(value);
            }else{
                result.add(value);
            }
        }
        result.addAll(even);
        return result;
    }

}
