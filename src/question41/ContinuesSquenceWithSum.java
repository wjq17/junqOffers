package question41;

public class ContinuesSquenceWithSum {

	static void FindContinuousSequence(int sum){
		if (sum<2) {
			return;
		}
		
		int  small=1;
		int big=2;
		int mid=(1+sum)/2;
		int curSum=small+big;
		
		while (small<mid) {
			if (curSum==sum) {
				 print (small,big);
			}
			
			while (curSum>sum&&small<mid) {
				curSum=curSum-small;
				small++;
				if (curSum==sum) {
					 print (small,big);
				}
			}
			big++;
			curSum=curSum+big;
		}
	}
	private static void print(int small, int big) {
		// TODO Auto-generated method stub
		for (int i = small; i <=big; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindContinuousSequence(15);
	}

}
