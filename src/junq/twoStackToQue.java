package junq;

import java.util.Stack;

/**
* @Author : JunqWang
*
* @Description: 用两个栈来实现队列
*
* @Date: 17:04 2018/5/23
**/

public class twoStackToQue {

    public static void main(String[] args) {
        System.out.println("用两个栈实现一个队列");
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()) {
            int peek = stack1.pop();
            stack2.push(peek);
        }
        return stack2.pop();
    }
}
