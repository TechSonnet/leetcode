  //给你单链表的头结点 head ，请你找出并返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1025, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import cn.ds.ListNode;

  public class MiddleOfTheLinkedList{
      public static void main(String[] args) {
           Solution solution = new MiddleOfTheLinkedList().new Solution();

          // case 1
          ListNode n1 = new ListNode(1);
          ListNode n2 = new ListNode(2);
          ListNode n3 = new ListNode(3);
          ListNode n4 = new ListNode(4);
          ListNode n5 = new ListNode(5);
//          ListNode n6 = new ListNode(6);
          n1.next = n2;
          n2.next = n3;
          n3.next = n4;
          n4.next = n5;
//          n5.next = n6;

          ListNode newList = solution.middleNode(n1);

          while (newList != null){
              System.out.println(newList.val);
              newList = newList.next;
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
    public ListNode middleNode(ListNode head) {

        // 1. 定义两个假头结点，指向 head
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
        ListNode fast = head, slow = head;

        // 2. 从中间节点截断，返回链表
        while (fast != null && fast.next != null){ // 这里的判空要学习，避免空指针问题
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }