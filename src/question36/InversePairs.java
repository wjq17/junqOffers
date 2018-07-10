package question36;

public class InversePairs {
	static int count=0;
	public static int inversePairs(int [] array) {

		int res=mergeSort(array,0,array.length-1);
		
		return res;
	}
	private static int mergeSort(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int mid=((high-low)>>1)+low;
		if (high>low) {
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge (array,low,mid,high);
		}
		return count;
	}
	private static void merge(int[] array, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int temp[]=new int[high-low+1];
		int k=high-low;
		int i=mid;
		int j=high;
		while (i>=low&&j>=mid+1) {
			if (array[i]>array[j]) {
				count=count+j-mid;
				temp[k--]=array[i--];
				
			}else {
				temp[k--]=array[j--];
			}
			
		}
		
		while (i>=low) {
			temp[k--]=array[i--];
		}
		while (j>=mid+1) {
			temp[k--]=array[j--];
		}
		
		for (int m = 0; m < temp.length; m++) {
			array[low+m]=temp[m];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                int array[]={7,5,6,4};
                int res=inversePairs(array);
                System.out.println(res);
                System.out.println("善哉!善哉!大地众生皆具如来智慧德相,但因妄想执着而不能证得,只要恢复了自己本有的清净自性,一切众生皆可成佛!"); 
	}

}
