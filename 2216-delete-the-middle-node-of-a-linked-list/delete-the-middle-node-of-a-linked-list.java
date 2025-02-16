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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null; // If only one node, return null

        ListNode mid = head, temp = head, prev = null;

        // Use slow and fast pointers to find the middle node
        while(temp != null && temp.next != null){
            prev = mid;
            mid = mid.next;
            temp = temp.next.next;
        }

        prev.next = mid.next; // Remove middle node
        return head;
    }
}