public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode cursor = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            if (ret == null) {
                ret = node;
            }
            if (cursor != null) {
                cursor.next = node;
            }
            cursor = node;
        }

        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(
                toListNode(new int[]{2, 4, 3}),
                toListNode(new int[]{5, 6, 4}));
        printListNode(ret);
    }

    static ListNode toListNode(int[] a) {
        ListNode ret = null;
        ListNode cursor = null;
        for (int i : a) {
            ListNode node = new ListNode(i);
            if (ret == null) {
                ret = node;
            }
            if (cursor != null) {
                cursor.next = node;
            }
            cursor = node;
        }
        return ret;
    }

    static void printListNode(ListNode node) {
        String sep = "";
        while (node != null) {
            System.out.print(sep + node.val);
            sep = ", ";
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}