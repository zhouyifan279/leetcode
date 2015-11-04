
public class Test {

	public ListNode toList(String str) {
		String[] strs = str.split("->");
		ListNode l = new ListNode(0);
		ListNode next = l;
		for(String s : strs) {
			next.next = new ListNode(Integer.valueOf(s));
			next = next.next;
		}
		
		return l.next;
	}
	
	
	public ListNode tail(ListNode head) {
		return head.next == null ? head : tail(head.next);
	}
	
	@org.junit.Test
	public void testReverse() {
		ListNode l = new Solution().reverse(toList("1->2->3"), 3);
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
	
	@org.junit.Test
	public void test() {
		ListNode head = toList("1->2->3->4->5->6");
		head = new Solution().reverseKGroup(head, 2);
		
		ListNode l = head;
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

}
