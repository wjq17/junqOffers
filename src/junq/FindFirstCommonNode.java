package junq;

/**
 * @Author : JunqWang
 * @Description: 两个链表的第一个公共节点
 *
 * @Date: 9:40 2018/6/20
 **/

class ListNode {  //节点定义
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1); //第一个链表
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node11 = new ListNode(4); //第二个链表
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(6);
        node11.next = node12;
        node12.next = node13;

        /*思路一：  长链表先走n步，然后长短链表同步遍历 */
        ListNode re = findFirstCommonNode(node1, node11);
        if (re == null)
            System.out.println("思路一： 没有公共节点");
        else
            System.out.println("思路一： 第一个公共节点是：" + re.val);


        /*思路二：当指针1访问到A的末尾开始访问B，当指针2访问到B的末尾开始访问A，这样，指针1,2会同时访问到公共节点 */
        ListNode re2 = findFirstCommonNode2(node1, node11);
        if (re2 == null)
            System.out.println("思路二： 没有公共节点");
        else
            System.out.println("思路二： 第一个公共节点是：" + re2.val);
    }

    private static ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;

    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        if (pHead1 == pHead2) return pHead1;
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        //让比较长的链表先走几步
        if (len1 > len2) {
            for (int i = 0; i < (len1 - len2); i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < (len2 - len1); i++) {
                pHead2 = pHead2.next;
            }
        }
        boolean flag = false;  //标志位，判断是否走到第一个公共节点
        ListNode result = null;
        while (!flag) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            if (pHead1.val == pHead2.val) {
                flag = true;
                result = pHead1;
            } else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return result;
    }

    /*求链表长度的方法，每次求链表涨肚，需要遍历一次单链表*/
    public static int getLength(ListNode pHead) {
        int len = 1;
        ListNode current = pHead;
        while (current.next != null) {
            len++;
            current = current.next;
        }
        return len;
    }
}
