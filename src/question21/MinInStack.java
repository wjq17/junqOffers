package question21;

import java.awt.DisplayMode;
import java.util.Stack;

public class MinInStack {

	static Stack<Integer> data=new Stack<Integer>();  // 数据栈
	static Stack<Integer> min=new Stack<Integer>();    // 辅助栈

  // 新栈的入栈操作
	public static void push(int node) {

		data.push(node);
		if (min.size()==0||node<top()) {
			min.push(node);
		}else {
			min.push(top());
		}
	}

	// 新栈 的弹出操作
	public static void pop() {

		if (data.size()>0&&min.size()>0) {
			data.pop();
			min.pop();
		}else {
			return;
		}
	}

	// 返回 辅助栈 的栈顶元素
	public static int top() {

		return min.peek();
	}

	// 返回最小元素，也就是辅助栈的栈顶元素
	public static int min() {
         return top();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        push(3);
        push(4);
       System.out.println("当前的最小值"+min());
        push(2);
        System.out.println("当前的最小值"+min());
        push(1);
        System.out.println("当前的最小值"+min());
        pop();
        System.out.println("当前的最小值"+min());
        pop();
        System.out.println("当前的最小值"+min());
        push(0);
        System.out.println("当前的最小值"+min());
		
	}

	

}
