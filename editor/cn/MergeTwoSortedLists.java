  //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3623, 👎 0 
//
//
//
//

  
  package cn;

  import cn.ds.ListNode;

  public class MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();

           // list1 测试数据
          ListNode l1n1 = new ListNode(1);
          ListNode l1n2 = new ListNode(2);
          ListNode l1n3 = new ListNode(4);
          l1n1.next = l1n2;
          l1n2.next = l1n3;

           // list2 测试数据
          ListNode l2n1 = new ListNode(1);
          ListNode l2n2 = new ListNode(3);
          ListNode l2n3 = new ListNode(4);
          l2n1.next = l2n2;
          l2n2.next = l2n3;

          ListNode listNode = solution.mergeTwoLists(l1n1, l2n1);
          while (listNode.next != null) {
              System.out.println(listNode.val + " ");
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //  1. 定义三个头结点，用于操作三个链表（两个参数链表，一个新链表）
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummy = new ListNode(-1, null);
        /**
         * 这里不要写成  ListNode p = dummy.next;
         * 这样写的话思路很不清晰，并且还有莫名的错误
         */
        ListNode p = dummy;

        //  2. 在任一链表还有元素时，将两个链表进行比较，比较小的元素插入新链表。
        // 此处是while，不是if
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        //  3. 当出现一链表为空时，将另一链表的所有元素插入新链表。
        if (l1 != null){
            p.next = l1;
        }

        if(l2 != null){
            p.next = l2;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }