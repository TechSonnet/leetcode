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

  import java.util.Comparator;
  import java.util.PriorityQueue;

  public class MergeKSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeKSortedLists().new Solution();

           ListNode l1n1 = new ListNode(1);
           ListNode l1n2 = new ListNode(4);
           ListNode l1n3 = new ListNode(5);
           l1n1.next = l1n2;
           l1n2.next = l1n3;

          ListNode l2n1 = new ListNode(1);
          ListNode l2n2 = new ListNode(3);
          ListNode l2n3 = new ListNode(4);
          l2n1.next = l2n2;
          l2n2.next = l2n3;

          ListNode l3n1 = new ListNode(2);
          ListNode l3n2 = new ListNode(6);
          l3n1.next = l3n2;

          // 这是否是一张图？
          ListNode[] lists = {l1n1,l2n1,l3n1};

          ListNode listNode = solution.mergeKLists(lists);

          while (listNode != null){  // 想清楚此处为什么是 listNode，而不是 listNode.next
              System.out.println(listNode.val);
              listNode = listNode.next;
          }


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
    public ListNode mergeKLists(ListNode[] lists) {
        // 参数校验
        if(lists.length == 0){
            return null;
        }

        // 1. 定义一个大小为k的优先队列，存储k个链表的头结点。
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode head:lists){
            if (head != null) {  // 这里的判空也忘了
                pq.add(head);
            }
        }

        // 2. 设置虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 3. 利用优先队列的特性，选出最小的那个节点放入链表。并且将该链表的下一个节点放入优先队列。
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null){ // 这里的判空，一开始忘记了
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }