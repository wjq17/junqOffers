package question34;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1=System.nanoTime();
		int res1=GetUglyNumber(150);  //方法一
		System.out.println("经过"+(System.nanoTime()-t1)+"纳秒后得到"+res1);
		long t2=System.nanoTime();
         int res2=GetUglyNumber2(150); // 方法二
         System.out.println("经过"+(System.nanoTime()-t2)+"纳秒后得到"+res2);
	}

	private static int GetUglyNumber(int index) {
		// TODO Auto-generated method stub
		if (index<=0) {
			return 0;
		}
		
		int number=0;
		int uglyFound=0;
		while (uglyFound<index) {
			++number;
			if (isUgly(number)) {
				uglyFound++;
			}
		}
		return number;
	}

	private static boolean isUgly(int number) {
		// TODO Auto-generated method stub
		while (number%2==0) {
			number/=2;
		}
		while (number%3==0) {
			number/=3;
		}
		while (number%5==0) {
			number/=5;
		}
		return number==1? true:false;
	}

	private static int GetUglyNumber2(int index) {
		// TODO Auto-generated method stub
		if (index<=0) {
			return 0;
		}
		int []arr=new int[index];
		arr[0]=1;
		int nextIndex=1;
		int index2=0;         
		int index3=0;
		int index5=0;
		
		while (nextIndex<index) {
			int min=Min(arr[index2]*2,arr[index3]*3,arr[index5]*5);
			arr[nextIndex]=min;
			
			while (arr[index2]*2<=arr[nextIndex]) {
				index2++;
			}
			
			while (arr[index3]*3<=arr[nextIndex]) {
				index3++;
			}
			while (arr[index5]*5<=arr[nextIndex]) {
				index5++;
			}
			
			nextIndex++;
			
		}
		
		int ugly=arr[nextIndex-1];
		return ugly;
		
		
		
	}

	private static int Min(int i, int j, int k) {
		// TODO Auto-generated method stub
		int min=(i<j)? i:j;
		
		return min=(min<k)? min :k;
	}

}
