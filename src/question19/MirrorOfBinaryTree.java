package question19;



import java.util.Scanner;

class TreeNode{
	int val;
	TreeNode left=null;
	TreeNode right=null;
	public TreeNode(int val) {
		this.val=val;
	}
}
public class MirrorOfBinaryTree {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		System.out.println("请输入树 的先序遍历:");
		TreeNode root=creatTree(in);
		
		System.out.println("下面是树的先序遍历:");
		display(root);
		System.out.println();
       
        Mirror(root);
        System.out.println("下面是镜像树的先序遍历:");
		display(root);
		
	}
	public static void Mirror(TreeNode root) {
        if(root==null) return ;
        if(root.left!=null||root.right!=null){
            TreeNode t=root.left;
            root.left=root.right;
            root.right=t;
        }
        
        if(root.left!=null) {
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
	
	// 打印二叉树
	private static void display(TreeNode root) {
		// TODO Auto-generated method stub

		if (root!=null) {
			System.out.print(root.val+"  ");
			display( root.left);
			display(root.right);

		}
	}
	// 创建二叉树
	private static TreeNode creatTree(Scanner in) {
		// TODO Auto-generated method stub
		TreeNode newNode;
		int val=in.nextInt();
		if (val==-1) {     //设置 -1 为结束数字
			val=in.nextInt();
		}
		if (val!=0) {    // 0 代表空节点
			newNode=new TreeNode(val);
		}else {
			newNode=null;
			return null;
		}

		newNode.left=creatTree(in);
		newNode.right=creatTree(in);

		return newNode;

	}

}
