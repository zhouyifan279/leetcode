public class Solution {
	// public boolean hasCycle(ListNode head) {
	// if(head == null) {
	// return false;
	// }
	//
	// ListNode next = head;
	// while(next.next != null) {
	// if(next.next == head) {
	// return true;
	// } else {
	// ListNode t = next.next;
	// next.next = head;
	// next = t;
	// }
	// }
	//
	// return false;
	// }
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode speed1 = head.next;
		ListNode speed2 = head.next.next;
		while (speed1 != speed2) {
			if (speed1 == null || speed2 == null)
				return false;
			if (speed2.next == null)
				return false;
			else {
				speed1 = speed1.next;
				speed2 = speed2.next.next;
			}
		}
		
		return true;
	}
}
