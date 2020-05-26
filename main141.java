package Leetcode;

/**
 * 141. 环形链表
 */
public class main141 {
    /**
     *  快慢指针法, 兔子与乌龟同时在头节点出发, 兔子每次跑两个节点, 乌龟每次跑一个节点, 如果兔子能够追赶到乌龟, 则链表是有环的
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            if(slow.val == fast.val){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
