package question13;

import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Collection;  
import java.util.LinkedList;  
import java.util.Scanner;  
class Node{  
    int val;  
    Node next;  
    public Node(int val) {  
        // TODO Auto-generated constructor stub  
        this.val=val;  
    }  
}  
public class MyLinkedList1 {  
    private static Node head,tail;   // 链表的 首节点和尾节点  
  
    public MyLinkedList1() {  
        // TODO Auto-generated constructor stub  
        head=tail=null;  
    }  
  
    public static boolean isEmpty() {  
        return head==null;  
    }  
// 头插法  
    public static void addFirst(int data){  
        Node newNode=new Node(data);  
        newNode.next=head;  
        head=newNode;  
    }  
// 添加一组数据  
    public static void add (Collection<Integer> c){  
        Object[] a = c.toArray();  
        int numNew = a.length;  
        if (numNew == 0)  
            return ;  
        for (Object o : a) {  
            addTail((int) o);  
        }  
  
    }  
// 尾插法  
    public static void addTail(int data){  
        Node newNode=new Node(data);  
        if (tail==null) {  
            head=tail=newNode;  
        }else {  
            tail.next=newNode;  
            tail=newNode;  
        }  
    }  
// 删除节点，本题的考查函数  
    public static void  deleteNode(Node nodeDel){  
        if (head==null||nodeDel==null) {  
            return;  
        }  
        // 要删除的节点不是尾节点  
        if (tail!=nodeDel) {  
            Node next=nodeDel.next;  
            nodeDel.val=next.val;  
            nodeDel.next=next.next;  
        }  
          
        if (tail==head) {  
            nodeDel=tail=null;  
        }  
          
        if (tail==nodeDel) {  
            Node current=head;  
            while (current.next!=tail) {  
                current=current.next;  
            }  
            current.next=nodeDel=null;  
            tail=current;  
        }  
          
          
    }  
      
  
  
    public static void main(String[] args) {  
  
  
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));  
  
        add(arrayList);  
        Node nodeDel=getNode(3);  
        deleteNode(nodeDel);  
        display (head);  
    }  
// 打印链表  
    private static void display(Node head) {  
        // TODO Auto-generated method stub  
        if (head==null) {  
            return;  
        }  
        System.out.println(head.val);  
          
        display(head.next);  
    }  
  
    // 得到 下标为 index 的结点  
    private static Node getNode(int index) {  
        // TODO Auto-generated method stub  
        if (index==0) {  
            return head;  
        }  
        Node cur=head;  
        for (int i = 1; i <=index; i++) {  
            cur=cur.next;  
        }  
        return cur;  
    }  
}  