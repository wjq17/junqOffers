//package junq;
//import java.util.ArrayList;
//import java.util.Scanner;
///**
// * @Author : JunqWang
// * @Description: 二叉树总和为某一值的路径
// * @Date: 10:52 2018/6/1
// **/
//
//
///*树节点的结构*/
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
//
//
//public class PathInTree {
//    public static void main(String[] args) {
//        System.out.println("请输入树的先序遍历:");
//
//        TreeNode root = creatTree();
//        System.out.println("打印出树（以先序遍历方式遍历打印）:");
//        display(root);
//        /*System.out.println("以下是所有满足和为该值的路径：");
//        ArrayList<ArrayList<Integer>> result = FindPath(root, 15);
//        System.out.println(result);*/
//    }
//
//    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//
//        return result;
//    }
//
//    // 打印二叉树
//    private static void display(TreeNode root) {
//        if (root != null) {
//            System.out.print(root.val + "  ");
//            display(root.left);
//            display(root.right);
//        }
//    }
//
//    // 创建二叉树
//    private static TreeNode creatTree() {
//        Scanner in = new Scanner(System.in);
//        TreeNode treeNode = new TreeNode(0);
//        if(!in.hasNextInt() || in.nextInt()==0){
//            return null;
//        }
//        int num = in.nextInt();
//        treeNode.val = num;
//        treeNode.left = creatTree(in);
//        treeNode.right = creatTree(in);
//        return treeNode;
//    }
//}
//
