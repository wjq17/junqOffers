package question07;

import java.util.Stack;  

public class StackToQueue {  
    static Stack<Integer> stack1 = new Stack<Integer>();  
    static Stack<Integer> stack2 = new Stack<Integer>();  
  
    public static void push(int node) {  
        stack1.push(node);  
    }  
  
    public static int pop() {  
        if(!stack2.isEmpty()){//弹出时，必须先考虑 stack2 是否还有元素，若有先处理  
            return stack2.pop();  
        }  
          
        // stack2 为空的情况  
        while (!stack1.isEmpty()) {   // stack1 不空时，一次性压人 stack2  
            stack2.push(stack1.pop());  
        }  
        if (!stack2.isEmpty()) {  
            return stack2.pop();  
        }else {  
            return -1;  
        }  
    }  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
        push(1);  
        push(2);  
        System.out.println(pop());  
        push(3);  
        System.out.println(pop());  
        System.out.println(pop());  
  
  
    }  
  
}  