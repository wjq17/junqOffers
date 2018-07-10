package question37;



class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FirstCommonNodesInLists {
	
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1==null||pHead2==null) {
			return null;
		}
        int len1=0;
        int len2=0;
        ListNode p=pHead1;
        ListNode p1=pHead1,p2=pHead2;
        while (p!=null) {
			len1++;
			p=p.next;
		}
        p=pHead2;
        while (p!=null) {
			len2++;
			p=p.next;
		}
        
        if (len1>len2) {
			for (int i = 0; i < len1-len2; i++) {
				p1=p1.next;
			}
		}else if (len1<len2) {
			for (int i = 0; i < len2-len1; i++) {
				p2=p2.next;
			}
		}
        while (p1!=p2) {
			p1=p1.next;
			p2=p2.next;
		}
        
        return p1;
		
		
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);
	    ListNode pNode6 = new ListNode(6);
	    ListNode pNode7 = new ListNode(7);
	    BuildNodes(pNode1, pNode2);
	    BuildNodes(pNode2, pNode3);
	    BuildNodes(pNode3, pNode6);
	    BuildNodes(pNode4, pNode5);
	    BuildNodes(pNode5, pNode6);
	    BuildNodes(pNode6, pNode7);
	    BuildNodes(pNode7, null);
	    
	    ListNode firstCommon=FindFirstCommonNode(pNode1,pNode4);
	    System.out.println(firstCommon.val);
	    System.out.println("善哉!善哉!大地众生皆具如来智慧德相,但因妄想执着而不能证得,只要恢复了自己本有的清净自性,一切众生皆可成佛!"); 
	    
	}
	static void BuildNodes(ListNode pNode, ListNode pNext)
	{
	    if(pNode != null)
	    {
	        pNode.next = pNext;
	       
	    }
	}
}
