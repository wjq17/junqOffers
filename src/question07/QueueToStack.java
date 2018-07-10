package question07;
import java.util.LinkedList;  
import java.util.Queue;  

public class QueueToStack {  
    static  Queue<Integer> q1=new LinkedList<Integer>();  
    static  Queue<Integer> q2=new LinkedList<Integer>();  
    public static void main(String[] args) {  

    //  pop();  
        push (1);  
        push (2);  
        push (3);  
        push(4);  
        pop ();  
        push(5);  
        pop();  
        pop();  
        pop();  
        pop();  

    }  
    private static void pop() {  
        // TODO Auto-generated method stub  
        if (q1.size()==0) {  // 当队列 q1 为空时，交换 q1 q2  
            if (q2.size()==0) {  
                System.out.println("栈内没有元素，请输入元素！");  
                System.exit(-1);  
            }  
            Queue<Integer > temp=q1;  
            q1=q2;  
            q2=temp;  
        }  
        if (q1.size()==1) {   // q1 的长度为 1 ，直接弹出  
            System.out.println(q1.poll());  
        }else {              //  q1 的长度大于 1，弹出直到长度为 1  
            while (q1.size()!=1) {  
              q2.offer(q1.poll());  
            }  
            System.out.println(q1.poll());    
        }  
    }  
    private static void push(int i) {  
        // TODO Auto-generated method stub  
        q1.offer(i);  
    }  

}  