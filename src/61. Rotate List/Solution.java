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

public class Solution {

    // slow-fast two pointer to find k-th from the bottom
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // judge k whether an integer multiple
        int sum = 0; // length of the List
        ListNode p = head;
        while (p != null) {
            p = p.next;
            sum++;
        }
        k %= sum;
        if (k == 0) return head;

        ListNode slow = head, fast = head;
        while (k-- > 0) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head; // location of fast pointer is at last of List
        return newHead;
    }

    // closed cycle and find k-th from the bottom
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // judge k whether an integer multiple
        int sum = 1;
        ListNode p = head;
        // judging condition is p.next in order to move p to the last node
        while (p.next != null) {
            p = p.next;
            sum++;
        }
        k %= sum;
        if (k == 0) return head;
        // closed cycle
        p.next = head;
        k = sum - k - 1;
        while (k-- > 0) head = head.next;
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

}

