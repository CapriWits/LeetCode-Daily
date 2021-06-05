import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/* 203. Remove Linked List Elements */
public class Solution {

    // public ListNode removeElements(ListNode head, int val) {
    //     if (head == null) return head;
    //     head.next = removeElements(head.next, val);
    //     return head.val == val ? head.next : head;
    // }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1); /* 1 <= Node.val <= 50 */
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }

}