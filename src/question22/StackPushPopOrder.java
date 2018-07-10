package question22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackPushPopOrder {
 static Stack<Integer> stack=new Stack<Integer>();
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length==0||popA.length==0||pushA.length!=popA.length){
            return false;
        }
		int j=0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (j<popA.length&&popA[j]==stack.peek()) {
				stack.pop();
				j++;
			}
		}
		return stack.empty()==true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] pushA={1,2,3,4,5};
		int [] popA={4,5,3,2,1};

		boolean res=IsPopOrder(pushA, popA);
		System.out.println(res);
	}

}
