// Last updated: 9/3/2025, 10:46:33 AM
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode current = head;
        int max = current.val; 
        while (current != null && current.next != null) {
            if (current.next.val < max) {
                current.next = current.next.next;
            } else {
                 max = current.next.val;
                current = current.next;
            }
        }
        
        return reverseList(head);
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}