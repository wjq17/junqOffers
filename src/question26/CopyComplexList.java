package question26;

import java.util.Scanner;



class ComplexListNode {
    int val;
    ComplexListNode next = null;
    ComplexListNode random = null;

    ComplexListNode(int val) {
        this.val = val;
    }
    
    
}
public class CopyComplexList {
	static void PrintList(ComplexListNode pHead)
	{
	    ComplexListNode pNode = pHead;
	    while(pNode != null)
	    {
	        System.out.printf("The value of this node is: %d.\n", pNode.val);

	        if(pNode.random != null)
	        	System.out.printf("The value of its sibling is: %d.\n", pNode.random.val);
	        else
	        	System.out.printf("This node does not have a sibling.\n");

	        System.out.printf("\n");

	        pNode = pNode.next;
	    }
	}

	static void BuildNodes(ComplexListNode pNode, ComplexListNode pNext, ComplexListNode random)
	{
	    if(pNode != null)
	    {
	        pNode.next = pNext;
	        pNode.random = random;
	    }
	}
	public static ComplexListNode Clone(ComplexListNode pHead)
    {
		CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);
       
    }
	
	/*private static ComplexListNode ReconnectNodes(ComplexListNode pHead) {
		ComplexListNode pCloned=null,pClonedHead=null,p=pHead;
		
		if (p!=null) {
			pCloned=pClonedHead=p.next;
			
			p.next=pCloned.next;
			p=p.next;
		}
		
		while (p!=null) {
			pCloned.next=p.next;
			pCloned=pCloned.next;
			
			p.next=pCloned.next;
			p=p.next;
		}
		
		return pClonedHead;
		
	}*/
	private static ComplexListNode ReconnectNodes(ComplexListNode pHead) {
		ComplexListNode pCloned=pHead.next,pClonedHead=pHead.next,p=pHead;
		
		while (p!=null&&pCloned.next!=null) {
			p.next=pCloned.next;
			p=p.next;
			pCloned.next=p.next;
			pCloned=pCloned.next;
		}
		
		return pClonedHead;
		
	}
	private static void ConnectSiblingNodes(ComplexListNode pHead) {
		ComplexListNode p=pHead;
		ComplexListNode pCloned=null;
		while (p!=null) {
			pCloned=p.next;
			
			if (p.random!=null) {
				pCloned.random=p.random.next;
			}
			
			p=pCloned.next;
		}
		
	}

	private static void CloneNodes(ComplexListNode pHead) {
		ComplexListNode p=pHead;
		while (p!=null ) {
			ComplexListNode pCloned=new ComplexListNode(p.val);
			
			pCloned.next=p.next;
			p.next=pCloned;
			p=pCloned.next;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexListNode pNode1 = new ComplexListNode(1);
	    ComplexListNode pNode2 = new ComplexListNode(2);
	    ComplexListNode pNode3 = new ComplexListNode(3);
	    ComplexListNode pNode4 = new ComplexListNode(4);
	    ComplexListNode pNode5 = new ComplexListNode(5);

	    BuildNodes(pNode1, pNode2, pNode3);
	    BuildNodes(pNode2, pNode3, pNode5);
	    BuildNodes(pNode3, pNode4, null);
	    BuildNodes(pNode4, pNode5, pNode2);
	    BuildNodes(pNode5, null, null);
	    
	   System.out. printf("The original list is:\n");
	    PrintList(pNode1);

	    ComplexListNode pClonedHead = Clone(pNode1);
        System.out.println("善哉!善哉!大地众生皆具如来智慧德相,但因妄想执着而不能证得,只要恢复了自己本有的清净自性,一切众生皆可成佛!");
	    System.out. printf("The cloned list is:\n");
	    PrintList(pClonedHead);
	}
	
}
