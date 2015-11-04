/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		int length = length(head);
		int groups = length / k;

		ListNode newHead = head;
		ListNode groupHead = null;
		ListNode formerGroupTail;
		
		for (int g = 0; g < groups; g++) {
			if (g == 0) {
				groupHead = head;
				newHead = reverse(groupHead, k);
			} else {
				formerGroupTail = groupHead;
				groupHead = groupHead.next;
				formerGroupTail.next = reverse(groupHead, k);
			}
		}

		return newHead;
	}

	public int length(ListNode head) {
		int count = 0;
		ListNode next = head;
		while (next != null) {
			count++;
			next = next.next;
		}

		return count;
	}

	public ListNode reverse(ListNode h, int len) {
		ListNode head = h;
		ListNode tail = head;
		for (int i = 1; i < len; i++) {
			ListNode newHead = tail.next;
			tail.next = newHead.next;
			newHead.next = head;
			head = newHead;
		}

		return head;
	}
}
