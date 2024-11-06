//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics链表 | 分治 | 堆（优先队列） | 归并排序 
//
// 👍 2905, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package cn;

import cn.ds.ListNode;


public class KthToLast{
    public static void main(String[] args) {
        Solution solution = new KthToLast().new Solution();

        ListNode l1n1 = new ListNode(1);
        ListNode l1n2 = new ListNode(2);
        ListNode l1n3 = new ListNode(3);
        ListNode l1n4 = new ListNode(4);
        ListNode l1n5 = new ListNode(5);
        l1n1.next = l1n2;
        l1n2.next = l1n3;
        l1n3.next = l1n4;
        l1n4.next = l1n5;

        int kthToLast = solution.kthToLast(l1n1, 2);

        System.out.println(kthToLast);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
        public int kthToLast(ListNode head, int k) {
            // 1. 初始化两个指针，使其指向头结点。
            ListNode p1 = head;
            ListNode p2 = head;

            // 2. 第一个指针走k步
            while (k != 0){
                p1 = p1.next;
                k--;
            }

            // 3. 第一，第二个指针同时往后走，知道第一个指针到达尾节点。
            while (p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p2.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}