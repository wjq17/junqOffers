package question24;

public class SquenceOfBST {
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if (sequence.length==0||sequence==null) {
			return false;
		}
		return    recursive(sequence,0,sequence.length-1);
	}

	private static boolean recursive(int []arr,int start,int end){
		if (start>=end) {
			return true;
		}
		
		int i=start;
		for (; i < end; i++) {
			if (arr[i]>arr[end]) {
				break;
			}
		}
		for (int j = i; j < end; j++) {
			if (arr[j]<arr[end]) {
				return false;
			}
		}
		
		return recursive(arr,start,i-1)&&recursive(arr, i, end-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={7,4,5,6};
		int arr1[]={5,7,6,9,11,10,8};
		System.out.println(VerifySquenceOfBST(arr));
		System.out.println(VerifySquenceOfBST(arr1));
	}

}
