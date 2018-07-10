package question27;

import java.util.ArrayList;
import java.util.Scanner;



class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}
public class ConvertBinarySearchTree {
	// 方法一   思路是先根据中序遍历把每个节点保存到列表中，然后变成右连得单链表，最后变成左连得单链表
	/*public TreeNode Convert(TreeNode pRootOfTree) {

		ArrayList<TreeNode> list=new ArrayList<TreeNode>();
		recursive (pRootOfTree,list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).val+" ");
		}
		getRightLinkedList (list);
		getLeftLinkedList(list);
		
		return pRootOfTree;
	}*/
	
	// 方法二 是剑指 Offer 给的答案，思路是:  原先指向左结点的指针调整为链表中指向前一个结点的指针，原先指向右结点的指针调整为链表中指向后一个结点的指针
	TreeNode pLastNodeInList=null;
	public TreeNode Convert(TreeNode pRootOfTree) {

		
		ConvertNode(pRootOfTree);
		
		TreeNode pHeadOfList=pLastNodeInList;
		while (pHeadOfList!=null&&pHeadOfList.left!=null) {
			pHeadOfList=pHeadOfList.left;
		}
		return pHeadOfList;
	}
	
	
	private void ConvertNode(TreeNode pNode) {
		// TODO Auto-generated method stub
		if (pNode==null) {
			return ;
		}
		//
		TreeNode pCurrent=pNode;
		if (pCurrent.left!=null) {
			ConvertNode(pCurrent.left);
		}
		
		//
		pCurrent.left=pLastNodeInList;
		if (pLastNodeInList!=null) {
			pLastNodeInList.right=pCurrent;
		}
		pLastNodeInList=pCurrent;
		
		
		
		//
		if (pCurrent.right!=null) {
			ConvertNode(pCurrent.right);
		}
		
		
	}
	private void getLeftLinkedList(ArrayList<TreeNode> list) {
		// TODO Auto-generated method stub
		if (list==null||list.size()==0) {
			return;
		}
		for (int i =list.size()-1; i >0; i--) {
			list.get(i).left=list.get(i-1);
		}
		list.get(0).left=null;
	}
	private void getRightLinkedList(ArrayList<TreeNode> list) {
		// TODO Auto-generated method stub
		if (list==null||list.size()==0) {
			return;
		}
		for (int i = 0; i < list.size()-1; i++) {
		     
		    list.get(i).right=list.get(i+1);
		   
		}
		list.get(list.size()-1).right=null;
	}
	private void recursive(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
		// TODO Auto-generated method stub
		if (pRootOfTree!=null) {
			recursive(pRootOfTree.left, list);
			list.add(pRootOfTree);
			recursive(pRootOfTree.right, list);
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		System.out.println("请输入树 的先序遍历:");
		TreeNode root=creatTree(in);
		System.out.println("下面是树 的先序遍历:");
		display(root);
        System.out.println();
        ConvertBinarySearchTree ly=new ConvertBinarySearchTree();
        
          root=ly.Convert(root);
          System.out.println("左到右:");
          displayLeft(root);
          System.out.println("\n右到左:");
          displayRight(root);
          
	}
	
	
	// 右到左显示
	private static void displayRight(TreeNode root) {
		// TODO Auto-generated method stub
		if (root!=null) {
			
			displayRight(root.right);
			System.out.print(root.val+" ");
		}
	}


	// 左到右显示
	private static void displayLeft(TreeNode root) {
		// TODO Auto-generated method stub
		if (root!=null) {
			System.out.print(root.val+" ");
			displayLeft(root.right);
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
