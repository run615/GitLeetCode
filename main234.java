package Leetcode;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class main234 {
    /**
     * 利用快慢指针，找到链表的中点
     */
    //ListNode slow,fast;
    //public boolean isPalindrome(ListNode head) {
    //    slow = fast = head;
    //    while(fast != null && fast.next != null){ // 这是链表长度是偶数的情况，比如 1->2->2->1，当fast = null时，break：
    //        slow = slow.next;
    //        fast = fast.next.next;  // 这样可以保证slow一直保持在fast中间
    //    }
    //    if(fast != null){  // 这是链表长度是奇数的情况，比如 1->2->3->2->1 ,如果fast指针没有指向null，说明链表是奇数，slow还得再向前一步；
    //        slow = slow.next;
    //    }
    //    ListNode left = head;
    //    ListNode right = reverse(slow);  // 从slow开始反转后面的链表，现在就可以开始比较回文串了。
    //    while(right != null){
    //        if(left.val != right.val){
    //            return false;
    //        }
    //        left = left.next;
    //        right = right.next;
    //    }
    //    return true;
    //}
    //// 1->2->3->2->1
    //// 1->2->3->2<-1
    //private ListNode reverse(ListNode head){
    //    ListNode pre = null, cur = head;
    //    while(cur != null){
    //        ListNode next = cur.next;
    //        cur.next = pre;
    //        pre = cur;
    //        cur = next;
    //    }
    //    return pre;
    //}

    /**
     * 借助二叉树后序遍历的思路，不需要显式反转链表也可以倒序遍历链表
     * 思路：一直将head递归到null，然后依次 print(head.val);
     *     void traverse（ListNode head){
     *         if(head == null){
     *             return
     *         }
     *         traverse(head.next);
     *         print(head.val);
     *     }
     */
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head); // 实际上就是把链表节点放入一个栈中，然后再拿出来，这个时候元素顺序就是反过来的。
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res & (right.val == left.val);
        left = left.next;
        return res;
    }


    public static void main(String[] args) {
        main234 p = new main234();
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        boolean res = p.isPalindrome(head);
        if (res) {
            System.out.println("ture");
        } else {
            System.out.println("false");
        }
    }
}
