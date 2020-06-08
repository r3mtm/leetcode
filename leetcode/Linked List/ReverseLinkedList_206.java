/*

TAGS={Linked List}

206. Reverse Linked List

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

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

    /* public ListNode reverseList(ListNode head) {

        // Using iteration

        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            head = curr;
            curr = curr.next;
            head.next = prev;
            prev = head;
        }
        
        return head;
    } */

    public ListNode reverseList(ListNode head) {
        // Using recursion.
        return helper(head, null);
    }

    public ListNode helper(ListNode head, ListNode node) {
        if (head == null) return null;
        if (head.next == null) {
            head.next = node;
            return head;
        }
        ListNode temp = head.next;
        head.next = node;
        return helper(temp, head);
    }
}