
class MinStack {

	class ListNode {
		int val;
		int min;
		ListNode next;

		public ListNode(int v, int m) {
			val = v;
			min = m;
		}
	}

	ListNode head;

	public void push(int x) {
		if (head == null) {
			head = new ListNode(x, x);
		} else {
			ListNode n = new ListNode(x, Math.min(x, head.min));
			n.next = head;
			head = n;
		}
	}

	public void pop() {
		if (head != null)
			head = head.next;
	}

	public int top() {
		if (head != null)
			return head.val;
		else
			return -1;
	}

	public int getMin() {
		if (head != null)
			return head.min;
		else
			return -1;
	}
}