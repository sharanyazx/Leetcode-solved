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
   public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // 
        ListNode curr = head;  // curren is head
        
        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev;          // Reverse the link
            prev = curr;               // Move prev to current
            curr = next;               // Move current to next
        }
        
        return prev; // New head
    }
}