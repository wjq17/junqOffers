package question05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    Node next=null;
    public Node(int data) {
        // TODO Auto-generated constructor stub
        this.data=data;
    }
}

public class MyLinkedList {
    private static Node head,tail;

    public MyLinkedList() {
        // TODO Auto-generated constructor stub
        head=tail=null;
    }

    public static boolean isEmpty() {
        return head==null;
    }

    public static void addFirst(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public static void add (Collection<Integer> c){
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return ;
        for (Object o : a) {
            addTail((int) o);
        }

    }
    public static void addTail(int data){
        Node newNode=new Node(data);
        if (tail==null) {
            head=tail=newNode;
        }else {
            tail.next=newNode;
            tail=newNode;
        }
    }

    public static void displayListReverse(Node head){
/*  方法一  用栈
    System.out.println("List  (tail-->head):  ");
        Stack<Integer> stack=new Stack<Integer>();
        Node current=head;
        while (current!=null) {
            stack.push(current.data);
            current=current.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+"  ");
        }*/

    // 方法二  用递归 
        if (head!=null ) {
            if (head.next!=null) {
                displayListReverse(head.next);
            }
        }

        System.out.println(head.data);

    }

    public static void main(String[] args) {


        ArrayList<Integer> arrayList=new ArrayList<Integer>();

        Scanner in=new Scanner(System.in);
        System.out.println("请输入链表的个数n:");
        int n=in.nextInt();
        System.out.println("请输入n个链表元素:");
        for (int i = 0; i < n; i++) {
            arrayList.add(in.nextInt());
        }
        add(arrayList);
        displayListReverse(head);
    }

}
