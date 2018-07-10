package question06;

class Node{
    int val;
    Node left;

    Node right;

    public Node(int val) {
        // TODO Auto-generated constructor stub
        this.val=val;
    }



}
public class MyCreateBinaryTree {

 static boolean valid=true;  //是否为有效输入
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int pre[]={1,2,4,7,3,5,6,8};
        int in[]={4,7,2,1,5,3,8,6};
    Node root=recreateBinaryTree(pre,in);
    if (valid) {
        display (root);
    }else {
        System.out.println("invalid input");
    }


    }
    private static void display(Node root) {
        // TODO Auto-generated method stub
        if (root!=null) {
            System.out.print(root.val+" ");
            display(root.left);
            display(root.right);
        }
    }
    private static Node recreateBinaryTree(int[] pre, int[] in) {
        // TODO Auto-generated method stub
        Node root=createRecursive(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private static Node createRecursive(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // TODO Auto-generated method stub
        if (pre==null||in==null) {
            valid=false;
            return null;
        }

        Node root=new Node(pre[startPre]);
        int rootInorder=startIn;  //在中序遍历中找到根节点的位置
        while (rootInorder<=endIn&&in[rootInorder]!=root.val) {
            rootInorder++;
        }

        if (rootInorder>endIn) {
            valid=false;
            return null;
        }

        int leftLength=rootInorder-startIn;

        if (leftLength>0) {//如果存在左子树
            root.left=createRecursive(pre,startPre+1,startPre+leftLength,in,startIn,rootInorder-1);
        }
        if (leftLength<endPre-startPre) {//如果存在右子树
            root.right=createRecursive(pre, startPre+leftLength+1, endPre, in, rootInorder+1, endIn);
        }
        return root;


    }


}