package question38;

public class NumberOfK {

	static int GetNumberOfK(int data[],int length,int k){
		int number=0;
		if (data.length!=0&&data!=null) {
			int first=GetFirstK(data,length,k,0,length-1);
			int last=GetLastK(data,length,k,0,length-1);
			if (first>-1&&last>-1) {
				number=last-first+1;
			}
		}
		return number;
	}private static int GetLastK(int[] data, int length, int k, int start, int end) {
		// TODO Auto-generated method stub
		if (start>end) {
			return -1;
		}
		
		int mid=((end-start)>>1)+start;
		int midData=data[mid];
		
		if (midData==k) {
			if( (mid<length-1&&data[mid+1]!=k) ||mid==length-1){
				return mid;
			}else  {
				start=mid+1;
			}
			
		}else if (mid<k) {
			start=mid+1;
		}else {
			end=mid-1;
		}
		
		return GetLastK(data, length, k, start, end);
	}
private static int GetFirstK(int[] data, int length, int k, int start, int end) {
		// TODO Auto-generated method stub
		if (start>end) {
			return -1;
		}
		
		int mid=((end-start)>>1)+start;
		int midData=data[mid];
		
		if (midData==k) {
			if( (mid>0&&data[mid-1]!=k )|| mid==0 ){
				return mid;
			}else {
				end=mid-1;
			}
		}else if (midData>k) {
			end=mid-1;
		}else {
			start=mid+1;
		}
		
		return GetFirstK(data, length, k, start, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,3,3,3,3,4,5};
		int array2[]={1,2,3,3,3,3,4,5};
		int res=GetNumberOfK(array, array.length,6);
		int res2=GetNumberOfK(array, array.length,3);
		System.out.println(res);
		System.out.println(res2);
	}

}
