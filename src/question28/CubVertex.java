package question28;

public class CubVertex {
          static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {0,1,2,3,4,5,6,7};  
	    cubVertex(A,8,0);  
	    System.out.println("总共有 "+count+" 个");
	}

	private static void cubVertex(int[] A, int len, int begin) {
		// TODO Auto-generated method stub
		
		if (A==null||len!=8) {
			return;
		}
		
		if (begin==len-1) {
			
			boolean can=true;
			
			for (int i = 0; i < len; i++) {
				for (int j = i+1; j < len; j++) {
					if (i-j==A[i]-A[j]||j-i==A[i]-A[j]) {
						can=false;
						break;
					}
				}
			}
			
			if (can) {
				for (int k : A) {
					System.out.print(k+" ");
				}
				count++;
				System.out.println();
			}
		}else {
			
			for (int i = begin; i < len; i++) {
				swap(A,begin,i);
				cubVertex(A, len, begin+1);
				swap(A, begin, i);
			}
		}
		
	}

	private static void swap(int[] A, int begin, int i) {
		// TODO Auto-generated method stub
		int temp=A[begin];
		A[begin]=A[i];
		A[i]=temp;
		
	}

}
