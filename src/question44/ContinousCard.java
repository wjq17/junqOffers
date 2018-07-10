package question44;

import java.util.Arrays;

public class ContinousCard {
	public static boolean isContinuous(int [] numbers) {
		if (numbers==null||numbers.length==0) {
			return false;
		}
		Arrays.sort(numbers);

		int ghost=0;
		for (int i : numbers) {
			if (i==0) {
				ghost++;
			}
		}

		if (ghost<2) {
			if ((numbers[4]-numbers[ghost])==4) {
				for (int i = ghost+1; i <=4; i++) {
					if (numbers[i]-numbers[i-1]==0) {
						return false;
					}
				}
			}else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numbers[]={1,3,4,5,0};
		boolean res=isContinuous(numbers);
		System.out.println(res);
	}

}
