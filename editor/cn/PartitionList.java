  //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 868, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import cn.ds.ListNode;

  import java.util.List;

  public class PartitionList{
      public static void main(String[] args) {
           Solution solution = new PartitionList().new Solution();

           ListNode ln1 = new ListNode(1);
           ListNode ln2 = new ListNode(4);
           ListNode ln3 = new ListNode(3);
           ListNode ln4 = new ListNode(2);
           ListNode ln5 = new ListNode(5);
           ListNode ln6 = new ListNode(2);
           ln1.next = ln2;
           ln2.next = ln3;
           ln3.next = ln4;
           ln4.next = ln5;
           ln5.next = ln6;


          ListNode partition = solution.partition(ln1, 3);

          while (partition != null){
              System.out.println(partition.val);
              partition = partition.next;
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
    public ListNode partition(ListNode head, int x) {
        // 1. 定义两个小链表，一个负责收集小于`x`的，一个负责收集大于等于`x`的，同时，大于`x`的那个链表，首个元素设置为`x`
        ListNode l1 = new ListNode(-1);
        ListNode p1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode p2 = l2;

        // 2. 遍历链表，开始组成两个链表
        while (head != null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        // 断开原链表，避免循环
        // 这里写的不好，应该为 head 在设置一个 dummy 节点，否则无法让 head 断开，逻辑不清晰
        // 但这里，不用假节点,在生成的小链表后断开，也能达到不循环的效果
        p1.next = null;
        p2.next = null;

        // 3. 链表组合
        p1.next = l2.next;

        return l1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }