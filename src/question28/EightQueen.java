package question28;
import static question28.StringPermutation.Permutation;

import java.util.ArrayList;;

public class EightQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="01234567";
	    char arr[]=str.toCharArray();
	    ArrayList<String> list=	Permutation(arr);
		System.out.println(list); 
		
		for (int i = 0; i < list.size(); i++) {
			if (isRight(list.get(i))) {
				System.out.println(list.get(i));
			}
		}
	}

	private static boolean isRight(String string) {
		// TODO Auto-generated method stub
		char []arr=string.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (i -j ==arr[i]-arr[j]|| j -i  ==arr[i]-arr[j]) {
					return false;
				}
			}
		}
		return true;
	}

}
