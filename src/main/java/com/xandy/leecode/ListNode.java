package com.xandy.leecode;

/**
 * @author liang.xu01
 * @description
 * @date 2020/5/1 17:34
 * @since 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode next = null;
            int temp;
            while(l1 != null || l2 != null) {
                if (l1 == null) {
                    temp = l2.val;
                    l2 = l2.next;
                } else if (l2 == null) {
                    temp = l1.val;
                    l1 = l1.next;
                } else if(l1.val >= l2.val){
                    temp = l2.val;
                    l2 = l2.next;
                } else {
                    temp = l1.val;
                    l1 = l1.next;
                }

                if (result == null) {
                    result = new ListNode(temp);
                    next = result;
                } else {
                    next.next = new ListNode(temp);
                    next = next.next;
                }

            }
            return result;

        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = listNode.new Solution();
        System.out.println(solution.mergeTwoLists(listNode, listNode3));
    }
}
