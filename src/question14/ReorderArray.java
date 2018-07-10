package question14;

import java.util.ArrayList;  

public class ReorderArray {  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
        int arr[]={1,2,3,4,5,6,7};  
    //  reOrderArray(arr);  
        reOrderArray1(arr);  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
    }  
  
    // 空间换时间，并保证奇数和奇数，偶数和偶数之间的相对位置不变。   
    private static void reOrderArray1(int[] arr) {  
        // TODO Auto-generated method stub  
        ArrayList<Integer> list=new ArrayList<Integer>();  
        for (int i = 0; i < arr.length; i++) {  
            if ((arr[i]&1)==1) {  
                list.add(arr[i]);  
            }  
        }  
        for (int i = 0; i < arr.length; i++) {  
            if ((arr[i]&1)==0) {  
                list.add(arr[i]);  
            }  
        }  
          
        for (int i = 0; i < arr.length; i++) {  
            arr[i]=list.get(i);  
        }  
    }  
  
    //官方答案  
    private static void reOrderArray(int[] arr) {  
        // TODO Auto-generated method stub  
        int i=0,j=arr.length-1;  
        while (i<j) {  
            while (i<j&&fun (arr[i])) {  
                i++;  
            }  
            while (i<j&&!fun(arr[j])) {  
                j--;  
            }  
              
            int temp=arr[i];  
            arr[i]=arr[j];  
            arr[j]=temp;  
        }  
    }  
  
    private static boolean fun(int i) {  
        // TODO Auto-generated method stub  
          
        return (i%2)==0 ? false :true;  
    }  
  
}  