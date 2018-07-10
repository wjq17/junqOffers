package junq;

/**
 * @Author : JunqWang
 * @Description: 二叉搜做树的后续遍历序列
 * @Date: 10:57 2018/5/31
 **/
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] in = new int[]{};
        boolean result = verifySquenceOfBST(in);
        System.out.println("这里应该是false: " + result);
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return judge(sequence,0,sequence.length-1);
    }


    public static boolean judge(int[] sequence, int start, int end) {
        if(start>end) return true;
        int root = sequence[end];
        //找到左子树序列的起始位置，起点是start，终点是首个大于根节点元素的前面一个元素
        int lefts = start;
        for(;lefts<end-1;lefts++){
            if(sequence[lefts]>root) break;
        }
        //右子树序列，即从首个大于根节点的元素到根节点的前一个元素，判断这个序列中是否每个元素都大于根节点
        int rights  = lefts;
        for(;rights<end-1;rights++){
            if(sequence[rights]<root) return false;
        }
        //递归调用，判断是否左子树和右子树的结构满足二叉搜索树的结构
       /* boolean isleft = judge(sequence,start,lefts-1);
        boolean isright = judge(sequence,rights,end-1);
        return (isleft && isright);*/
       return (judge(sequence,start,lefts-1) && judge(sequence,rights,end-1));

    }
}
