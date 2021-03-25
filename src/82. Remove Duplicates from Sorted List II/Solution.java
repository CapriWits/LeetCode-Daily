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

	// Iteration Solution
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0, head);
        ListNode curNode = dummyHead; // curNode start from dummyHead
        // there are at least two node after current node
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int num = curNode.next.val;
                // delete node which has same num
                while (curNode.next != null && curNode.next.val == num) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return dummyHead.next;
    }

    // Recursion Solution
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            // equals jump the same node, then recursion the next node to operate behind listNode
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // now Head is the last of the same nodes, so recursion object is head.next
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}

