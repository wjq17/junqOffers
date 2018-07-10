package question41;

import java.util.ArrayList;

public class TwoNumbersWithSum {
	
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
      ArrayList< Integer> list=new ArrayList<Integer>();
        int i=0;
        int j=array.length-1;
        while (i<j) {
			int curSum=array[i]+array[j];
			if (curSum==sum) {
				list.add(array[i]);
				list.add (array[j]);
				return list;
		
			}else if (curSum>sum) {
				j--;
			}else {
				i++;
			}
		}
       
        return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int arr[]={1,2,4,7,8,11,15};
         ArrayList< Integer> list=FindNumbersWithSum(arr, 15);
         System.out.println(list);
	}

}
