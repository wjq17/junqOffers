package question16;

import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Collection;  
  
class ListNode {  
    int val;  
    ListNode next = null;  
  
    ListNode(int val) {  
        this.val = val;  
    }  
}  
public class ReverseList {  
    private static ListNode head,tail;   // 链表的 首节点和尾节点  
  
    public ReverseList() {  
        // TODO Auto-generated constructor stub  
        head=tail=null;  
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
        ListNode newNode=new ListNode(data);  
        if (tail==null) {  
            head=tail=newNode;  
        }else {  
            tail.next=newNode;  
            tail=newNode;  
        }  
    }  
    // 打印链表  
    private static void display(ListNode head) {  
        // TODO Auto-generated method stub  
        if (head==null) {  
            return;  
        }  
        System.out.println(head.val);  
  
        display(head.next);  
    }  
    // 非递归方法  
    private static ListNode ReverseList1(ListNode head) {  
        ListNode newNode=null;  
        ListNode cur=head;  
        ListNode pre=null,next=null;  
        while (cur!=null) {  
            next=cur.next;  
            if (next==null) {  
                newNode=cur;  
            }  
            cur.next=pre;  
            pre=cur;  
            cur=next;  
  
        }  
        return newNode;  
  
    }  
    // 递归方法  
    public static ListNode ReverseList(ListNode head) {  
        if (head==null) {  
            return null;  
        }  
        ListNode tail=head;  
        while(tail.next!=null) tail=tail.next;  
        recursive(head);  
        head.next=null;  
        return tail;  
    }  
    private static ListNode recursive(ListNode head){  
        ListNode cur=head;  
  
        if(cur.next!=null){  
            ListNode    nextNode=recursive(cur.next);  
            nextNode.next=cur;  
        }  
  
        return cur;  
    }  
  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));  
  
        add(arrayList);  
        //  ListNode node=  ReverseList(head);   //递归方法  
        ListNode node1= ReverseList1(head);      //非递归方法  
        display(node1);  
    }  
  
  
}  