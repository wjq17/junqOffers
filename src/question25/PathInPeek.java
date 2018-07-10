package question25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}
public class PathInPeek {
	
	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list=new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

		int currentSum=0;
		recurisve(root,target,currentSum);


		return result;
	}
	private void recurisve(TreeNode root,int target,int currentSum) {
		currentSum+=root.val;
		list.add(root.val);
		boolean isLeaf=root.left==null&&root.right==null;
		if (currentSum==target&&isLeaf) {
			
			result.add(new ArrayList<Integer>(list)); //注意：此处不能 是 result.add(list)  ,因为list 只是一个指针，list的内容 会变。
		}
		
		if (root.left!=null) {
			recurisve(root.left, target, currentSum);
		}
		if (root.right!=null ) {
			recurisve(root.right, target, currentSum);
		}
		
		list.remove(list.size()-1);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		System.out.println("请输入树 的先序遍历:");
		TreeNode root=creatTree(in);
		System.out.println("下面是树 的先序遍历:");
		display(root);
        System.out.println();
		PathInPeek ly=new PathInPeek();
		ly.FindPath(root, 22);
		System.out.println("以下是所有路径");
		System.out.println(ly.result);
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
			// 打印二叉树
			private static void display(TreeNode root) {
				// TODO Auto-generated method stub

				if (root!=null) {
					System.out.print(root.val+"  ");
					display( root.left);
					display(root.right);

				}
			}
}
