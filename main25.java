package Leetcode;

import java.util.List;
import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class main25 {
    /**
     * 利用辅助栈的方法
     */
    //public ListNode reverseKGroup(ListNode head, int k) {
    //    if (head == null || k <= 0) {
    //        return head;
    //    }
    //    // 用栈来保存链表的节点
    //    Stack<ListNode> stack = new Stack<>();
    //    ListNode dummy = new ListNode(-1); // dummy:
    //    dummy.next = head;
    //    ListNode p = dummy;
    //    int count = k;
    //    while (p != null && p.next != null) {
    //        ListNode tmp = p.next;
    //        // 不断的将节点加入栈中
    //        while (tmp != null && count > 0) {
    //            stack.push(tmp);
    //            tmp = tmp.next;
    //            count--;
    //        }
    //        // 现在栈中的第一个元素，就是原链表中的第k个
    //        // 这里备份第k+1个节点，用作后面串联用
    //        ListNode nextNode = stack.peek().next;
    //        // count == 0 说明栈中正好存了k个元素，挨个弹出来并串联起来
    //        // 否则就退出循环
    //        if (count == 0) {
    //            while (stack.size() > 0) {
    //                p.next = stack.pop();
    //                p = p.next;
    //            }
    //        } else {
    //            break;
    //        }
    //        p.next = nextNode;
    //        count = k;
    //    }
    //    return dummy.next;
    //}

    /**
     * 利用反转链表
     * 反转k个，于是就遍历k个链表，然后将第k个节点的next指向空(防止循环)，这样就得到了长度为k的单链表了。
     * 之后我们将长度为k的链表直接交由反转链表函数处理，于是我们就可以得到长度为k的反转链表了。
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        int count = k;
        //增加一个哨兵节点，之后不断遍历链表
        while (p.next != null) {
            ListNode tmp = p;
            //遍历得到k个长度的链表
            while (tmp != null && tmp.next != null && count > 0) {
                tmp = tmp.next;
                count--;
            }
            // 如果k == 0 说明符合条件，就反转这一组链表
            // 反转之前需要将下一个节点保存，并设置next为空，防止循环指向
            // 假设链表为 1 -> 2 -> 3 -> 4，下面的nextNode 就是4，tail是1
            if (count == 0) {
                ListNode nextNode = tmp.next;
                ListNode tail = p.next;
                tmp.next = null;
                p.next = reverse(tail);
                tail.next = nextNode;
                p = tail;
                count = k;
            } else {
                break; // 如果遍历后的链表长度不是k，则不满足反转条件
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        main25 p = new main25();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode res = p.reverseKGroup(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

