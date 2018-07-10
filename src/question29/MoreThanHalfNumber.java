package question29;

import java.util.ArrayList;
import java.util.Arrays;

public class MoreThanHalfNumber {
  static   boolean inputInvalid=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numbers[]={0,2,1,2,2,3,2,2,5,4,2};
		for (int i : numbers) {
			
		}
		int result=moreThanHalfNum(numbers,numbers.length);
		
		System.out.println(result);
	}

	

	private static int moreThanHalfNum(int[] numbers,int len) {
		// TODO Auto-generated method stub
		if (CheckInvalidArray(numbers,len)) {
			return 0;
		}
		
		int mid=len>>1;
		int start=0;
		int end=len-1;
		int index=partition(numbers,len,start,end);
		while (index!=mid) {
			if (index>mid) {
				end=index-1;
				index=partition(numbers, len, start, end);
			}else {
				start=index+1;
				index=partition(numbers, len, start, end);
			}
		}
		
		int result=numbers[mid];
		if (!CheckMoreThanHalf(numbers,len,result)) {
			result=0;
		}
		
		return result;
		
		
	}

	private static boolean CheckMoreThanHalf(int[] numbers, int len, int result) {
		// TODO Auto-generated method stub
		int times=0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]==result) {
				times++;
			}
		}
		boolean isMoreThanHalf=true;
		if (times*2<=len) {
			inputInvalid=true;
			isMoreThanHalf=false;
		}
		return isMoreThanHalf;
	}

	private static int partition(int[] numbers, int len, int left, int right) {
		// TODO Auto-generated method stub
		int i=left;
		int j=right;
		int key=numbers[left];
		
		while (i<j) {
			while (i<j&&numbers[j]>=key)  j--;
			numbers[i]=numbers[j];
			while (i<j&&numbers[i]<=key)  i++;
			numbers[j]=numbers[i];
		}
		numbers[i]=key;
		return i;
	}

	private static boolean CheckInvalidArray(int[] numbers, int len) {
		// TODO Auto-generated method stub
		if (numbers==null||len<=0) {
			inputInvalid=true;
		}
		return inputInvalid;
	}

}
