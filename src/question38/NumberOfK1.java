package question38;

public class NumberOfK1 {
	public static int GetNumberOfK(int [] array , int k) {
		int firstK=	recursiveFirstK(array,0,array.length-1,k);
		int lastK=	recursiveLastK(array,0,array.length-1,k);
		System.out.println(firstK+"  "+lastK);
		return firstK==-1?0:lastK-firstK+1;


	}
	private static int recursiveLastK(int[] array, int left, int right, int k) {
		int i=left;
		int j=right;
		int lastKIndex = 0;
		while (i<j) {
			if (j-i==1&&array[i]!=k&&array[j]!=k) {

				return -1;
			}
			int mid=((i-j)>>1)+j;
			if (array[mid]>k) {
				j=mid-1;
			}else if (array[mid]<k) {
				i=mid+1;
			}else {
				i=mid;
				break;
			}
		}
		if (array[i]!=k) {
			return -1;
		}
		if (i<right&&array[i]!=array[i+1]) {
			lastKIndex=i;
		}else if (i==right) {
			lastKIndex=right;
		}else if (i<right&&array[i+1]==array[i]) {
			lastKIndex=recursiveLastK(array, i+1, right, k);
		}
		return lastKIndex;
	}
	private static int  recursiveFirstK(int[] array, int left, int right, int k) {
		int i=left;
		int j=right;
		int firstKIndex = 0;
		while (i<j) {
			if (j-i==1&&array[i]!=k&&array[j]!=k) {

				return -1;
			}
			int mid=((i-j)>>1)+j;
			if (array[mid]>k) {
				j=mid-1;
			}else if (array[mid]<k) {
				i=mid+1;
			}else {
				i=mid;
				break;
			}
		}

		if (array[i]!=k) {
			return -1;
		}
		if (i>left&&array[i-1]!=array[i]) {
			firstKIndex=i;
		}else if (i==left) {
			firstKIndex=left;
		}else if (i>left&&array[i-1]==array[i]) {
			firstKIndex=recursiveFirstK(array, left, i-1, k);
		}
		return firstKIndex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,3,3,3,3,4,5};
		int res=GetNumberOfK(array, 6);
		System.out.println(res);
	}

}
