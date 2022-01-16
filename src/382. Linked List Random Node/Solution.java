import java.util.Random;

/* 382. Linked List Random Node */
public class Solution {
    ListNode head;
    Random random = new Random();


    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int res = 0, i = 1;
        for (ListNode node = head; node != null; node = node.next, i++) {
            if (random.nextInt(i) == 0)
                res = node.val;
        }
        return res;
    }
}

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
