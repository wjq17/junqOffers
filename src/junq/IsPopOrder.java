package junq;

import java.util.Stack;

/**
* @Author : JunqWang
*
* @Description: 栈的压入、弹出序列
*
* @Date: 15:43 2018/5/30
**/

public class IsPopOrder {
    public static void main(String[] args){
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};
        int[] pop2 = new int[]{4,3,5,1,2};
        boolean is1 = IsPopOrder(push,pop);
        System.out.println("这里应该是true：==="+is1);
        boolean is2 = IsPopOrder(push,pop2);
        System.out.println("这里应该是false：==="+is2);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int k =0;
        for(int i =0;i<pushA.length;i++){
            int a = pushA[i];
            stack.push(a);
            for(int j=k;j<popA.length;j++){
                if(stack.peek()==popA[j]){
                    stack.pop();
                    continue;
                }else{
                    k=j;
                    break;
                }
            }
        }
        boolean result = stack.isEmpty()?true:false;
        return result;
    }
}
