package question15;

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
public class KthNodeFromEnd {  
    private static ListNode head,tail;   // 链表的 首节点和尾节点  
  
    public KthNodeFromEnd() {  
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
// 找到倒数第K个节点  
    public static ListNode FindKthToTail(ListNode head,int k) {  
  
        if(head==null||k<=0)  return null;  //链表0节点和K==0  
        ListNode fast=head,low=null;  
        for(int i=0;i<k-1;i++){  
            if(fast.next!=null)        //K>链表节点的个数时  
                fast=fast.next;  
            else  
                return null;  
        }  
  
        low=head;  
        while(fast.next!=null){  
            fast=fast.next;  
            low=low.next;  
        }  
        return low;  
    }  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));  
        add(arrayList);  
        int k=4;  
        ListNode node=FindKthToTail(head,k);  
  
        System.out.println(node.val);  
    }  
  
}  