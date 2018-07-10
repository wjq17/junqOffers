package question45;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
	int val;
	Node next=null;
	public Node(int val) {

		this.val=val;
	}
}
public class Joesph {
  static int M;
    public static void addAtTail(Node node){
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入链表元素的个数 n 和最初的 m: ");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int M=in.nextInt();
		int arr[]=new int[n];
		System.out.println("请输入链表元素: ");
		// 尾插法建单链表
		Node head=null,p=null;
		for (int i = 0; i < n; i++) {
			Node newNode=new Node(in.nextInt());
			if (head==null) {
				p=head=newNode;
			}else {
				p.next=newNode;
				p=newNode;
			}
			
		}
 
		p.next=head;        // 表尾链接头结点,构成环
		System.out.println("以下是输出队列: ");
		joesph(p,M,n);     
       

	}
	private static void joesph(Node p, int m, int n) {
		// TODO Auto-generated method stub
		Node q=p;
		if (n==1) {
			System.out.print(p.val);
			return;
		}
		m=m%n;
		if (m==0) {
			m=n;
		}
		
		for (int i = 1; i <=m; i++) {
			p=q;
			q=q.next;
		}
		
		p.next=q.next;
		int key=q.val;
		System.out.print(key+" ");
		
		joesph(p,M , n-1);
		
	}

}


