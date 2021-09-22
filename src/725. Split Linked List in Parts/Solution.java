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

/* 725. Split Linked List in Parts */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null && ++n > 0) temp = temp.next;
        int slice = n / k, remainder = n % k;
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            res[i] = curr;
            int partSize = slice + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++)
                curr = curr.next;
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return res;
    }
}