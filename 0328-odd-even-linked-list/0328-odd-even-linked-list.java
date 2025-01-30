/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;  // Handle edge cases

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // To reconnect odd and even lists at the end

        while (even != null && even.next != null) {
            odd.next = even.next;  // Link current odd node to next odd node
            odd = odd.next;        // Move odd pointer
            even.next = odd.next;  // Link current even node to next even node
            even = even.next;      // Move even pointer
        }

        odd.next = evenHead;  // Append even list after odd list
        return head;
    }
}