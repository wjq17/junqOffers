package question31;

public class GreatestSumOfSubarrays {
	static int max=-Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]={1,-2,3,10,-4,7,2,-5};
           long result=greatestSumOfSubarrays(arr,arr.length);
           recursive(arr,arr.length-1);
           System.out.println("递归解法:  "+max);
           System.out.println("普通解法:  "+result);
	}

	private static int recursive(int[] arr, int index) {
		// TODO Auto-generated method stub
		if (index==0) {
			return arr[index];
		}
		 
		
		int curSum=recursive(arr, index-1);           // curSum 代表递归表达公式中的 f(i)
		if (curSum>0) {
			curSum=curSum+arr[index];
		}else {
			curSum=arr[index];
		}
		if (max<curSum) {
			max=curSum;
		}
		
		return curSum;
		
	}

	private static Long greatestSumOfSubarrays(int[] arr, int length) {
		// TODO Auto-generated method stub
		if (arr.length==0||arr==null) {
			return null;
		}
		int max=arr[0];          
		int curSum=arr[0];      
		for (int i = 1; i < arr.length; i++) {
			if (curSum<=0) {
				curSum=arr[i];
				
			}else {
				curSum=curSum+arr[i];
			}
			
			if (curSum>max) {
				max=curSum;
			}
		}
		return (long) max;
	}

}
