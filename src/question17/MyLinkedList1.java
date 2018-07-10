package question17;
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
	private  Node head,tail;   // 链表的 首节点和尾节点

	public MyLinkedList1() {
		// TODO Auto-generated constructor stub
		head=tail=null;
	}

	
// 添加一组数据
	public  void add (Collection<Integer> c){
		Object[] a = c.toArray();
		int numNew = a.length;
		if (numNew == 0)
			return ;
		for (Object o : a) {
			addTail((int) o);
		}

	}
// 尾插法
	public  void addTail(int data){
		Node newNode=new Node(data);
		if (tail==null) {
			head=tail=newNode;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
	}

	// 合并函数，本题考点
	public Node Merge(Node list1,Node list2) {
        if(list1==null) return list2;
        if(list2==null)  return list1;
        Node newHead=null;
        if(list1.val<list2.val){
        	newHead=list1;
        	newHead.next=Merge(newHead.next,list2);
        }else{
        	newHead=list2;
        	newHead.next=Merge(list1,newHead.next);
        }
        return newHead;
    }

	public static void main(String[] args) {


		ArrayList<Integer> arrayList1=new ArrayList<Integer>(Arrays.asList(1,3,5,7));
		ArrayList<Integer> arrayList2=new ArrayList<Integer>(Arrays.asList(2,4,6,8));
        MyLinkedList1 list1=new MyLinkedList1();
        MyLinkedList1 list2=new MyLinkedList1();
        
		list1.add(arrayList1);
		list2.add(arrayList2);
		Node newHead=list1.Merge(list1.head, list2.head);
		list1.display (newHead);
	}
// 打印链表
	private  void display(Node head) {
		// TODO Auto-generated method stub
		if (head==null) {
			return;
		}
		if (head.next!=null) {
			System.out.print(head.val+"->");
		}else {
			System.out.print(head.val);
		}
		
		
		display(head.next);
	}

	
}
