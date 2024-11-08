  //给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 
//
// 👍 1164, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import cn.ds.ListNode;

  public class RemoveDuplicatesFromSortedList{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

          ListNode l1n1 = new ListNode(1);
          ListNode l1n2 = new ListNode(1);
          ListNode l1n3 = new ListNode(2);
          ListNode l1n4 = new ListNode(3);
          ListNode l1n5 = new ListNode(3);
          l1n1.next = l1n2;
          l1n2.next = l1n3;
          l1n3.next = l1n4;
          l1n4.next = l1n5;

          ListNode list = solution.deleteDuplicates(l1n1);
          while (list != null){
              System.out.println(list.val);
              list = list.next;
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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;

        // 1. 定义两个指针，slow、fast，同时指向链表头结点
        ListNode slow = head, fast = head;

        // 2. 快指针先开始移动，当扫描到的元素，和慢指针指向的元素不同时，则将该元素赋值给慢指针的下一个元素。
        while (fast != null){
            if(slow.val != fast.val){
                slow = slow.next;
                slow.val = fast.val;
            }else {
                fast = fast.next;
            }
        }

        slow.next = null;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }