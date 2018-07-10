package question31;

public class GetMaxSum {

	static int max=-Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={-2,-8,-1,-5,-9};
        recursive(arr,arr.length-1);
        System.out.println(max);
	}

	private static int recursive(int[] arr, int index) {
		// TODO Auto-generated method stub
        if(arr.length==0||arr==null) {  
            max=0;  
           return 0  ;
       }  
		if (index<=0) {
			return arr[index];
		}
		 
		
		int curSum=recursive(arr, index-1);
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

}
