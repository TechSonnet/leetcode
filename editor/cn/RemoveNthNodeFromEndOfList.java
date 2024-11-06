  //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2969, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import cn.ds.ListNode;

  public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

           // case 1
           ListNode n1 = new ListNode(1);
           ListNode n2 = new ListNode(2);
           ListNode n3 = new ListNode(3);
           ListNode n4 = new ListNode(4);
           ListNode n5 = new ListNode(5);
           n1.next = n2;
           n2.next = n3;
           n3.next = n4;
           n4.next = n5;

          // case 2
//          ListNode n1 = new ListNode(1);


          ListNode re = solution.removeNthFromEnd(n1,2);

          while (re != null){
              System.out.println(re.val);
              re = re.next;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 定义第一个指针，先走n步。
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode end = pre;  // 定义 pre，可以简化逻辑，不然，就需要考虑 n 到底是否需要 +1


        while (n > 0){
            end = end.next;
            n--;
        }

        // 2. 定义第二个指针，两个指针一起走，定位倒数第n个节点。
        ListNode start = pre; // 命名也有技巧，pre、start、end 见名知意，比 p1,p2 啥的要好的多

        while (end.next != null){
            start = start.next;
            end = end.next;
        }

        // 3. 定义一个temp节点，借助其删除倒数第n个节点
        ListNode temp = start.next;
        start.next = temp.next;

        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }