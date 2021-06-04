import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/* 160. Intersection of Two Linked Lists */
public class Solution {
    /* HashSet */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode p = headA;
    //     while (p != null) {
    //         set.add(p);
    //         p = p.next;
    //     }
    //     p = headB;
    //     while (p != null) {
    //         if (set.contains(p)) {
    //             return p;
    //         }
    //         p = p.next;
    //     }
    //     return null;
    // }

    /* Double pointer */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}