package junq;
/**
* @Author : JunqWang
*
* @Description: 复杂链表的复制
*
* @Date: 10:07 2018/6/8
**/

public class RandomListCopy {
    // 节点类
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //主函数
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomListNode head=new RandomListNode(1);
        RandomListNode b=new RandomListNode(2);
        RandomListNode c=new RandomListNode(3);
        RandomListNode d=new RandomListNode(4);
        RandomListNode e=new RandomListNode(5);
        head.next=b;
        head.random=c;
        b.next=c;
        b.random=e;
        c.next=d;
        c.random=null;
        d.next=e;
        d.random=b;
        e.next=null;
        e.random=null;
        RandomListCopy m=new RandomListCopy();
        RandomListNode temp=null;
        temp=m.Clone(head);
        while(temp!=null){
            System.out.println(temp.label);
            temp=temp.next;
        }
    }

    /*
     * 复制复杂链表，调用复制节点方法和连接random节点方法后，再调用拆分两个链表的方法
     */
    public RandomListNode Clone(RandomListNode pHead) {
        createDoubleNode(pHead);

        connectRandomNode(pHead);

        RandomListNode newHead = ReconnectNodes(pHead);
        return newHead;

    }

    /*
     * 复制节点，把新建的节点A‘连接在原节点A后
     */
    private void createDoubleNode(RandomListNode pHead) {
        RandomListNode tmpNode = pHead;
        while (tmpNode != null) {
            RandomListNode node = new RandomListNode(tmpNode.label);
            node.next = tmpNode.next;
            tmpNode.next = node;
            tmpNode = node.next;
        }
    }

    /*
     * 链接random节点，eg. 在原链表中A的random是B，那么在新链表中，A’链接B‘
     */
    private void connectRandomNode(RandomListNode pHead) {
        RandomListNode tmpNode = pHead;
        while (tmpNode != null) {
            if (tmpNode.random != null) {
                RandomListNode node = tmpNode.next;
                node.random = tmpNode.random.next;
                tmpNode = node.next;
            } else {
                tmpNode = tmpNode.next.next;
            }
        }
    }

    /*
     * 把两个相连的链表拆分成两个
     */
    private RandomListNode ReconnectNodes(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode tmpNode = pHead;
        RandomListNode newHead = pHead.next;

        while (tmpNode != null) {
            RandomListNode node = tmpNode.next;
            tmpNode.next = node.next;
            if (node.next != null)
                node.next = node.next.next;
            else
                node.next = null;
            tmpNode = tmpNode.next;
        }

        return newHead;
    }

}
