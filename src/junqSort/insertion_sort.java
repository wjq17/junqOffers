package junqSort;

import java.util.Arrays;

/**
* @Author : JunqWang
*
* @Description: 插入排序--
 * 类比拿牌，每次找到一个合适的位置插入待排序元素。每次将待排序元素与已排序序列的最后一个元素依次向前比较，知道找到一个合适的位置放入。
 * 时间复杂度O(N^2),是最稳定的算法
*
* @Date: 14:41 2018/5/24
**/

public class insertion_sort {
    public static void main(String[] args){
        int[] a = new int[]{7,9,4,5,16,23,14,52,3,9,7,8};
        System.out.print("原始序列为：");
        for(int n:a)
            System.out.print(n+" ");
        System.out.println("");//换行

        insertSort(a);
        System.out.print("插入排序为：");
        for(int n:a)
            System.out.print(n+" ");
    }

    public static int[] insertSort(int[] array){
        if(array==null || array.length == 0)
            return null;
        //每次向已排序序列中的合适位置插入一个元素
        for(int i=1;i<array.length;i++){
            int current = array[i];
            int position =i;
            //从0到i-1时已排序好的序列
            for(int j =i-1;j>=0;j--){
                //比待插入元素大，则需要向后挪一位
                if(array[j]>current){
                    array[j+1]=array[j];
                    position +=-1;
                }else{ //比待插入元素小，则说明它后面的位置就是待插入元素应该在的位置，此时可以跳出循环
                    break;
                }
            }
            //把待插入元素放到找到的合适位置中
            array[position]=current;
            System.out.print("第"+i+"次，在此次插入排序前，前"+i+"个元素有序，此次插入后，前"+(i+1)+"个元素有序,有序序列为：");
            for(int x = 0;x<i+1;x++){
                System.out.print(array[x]+" ");
            }
            System.out.println(" ");
        }
        return array;
    }
}
