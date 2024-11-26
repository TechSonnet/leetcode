  //给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1243, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import cn.ds.TreeNode;

  import java.util.LinkedList;
  import java.util.Queue;

  public class MinimumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MinimumDepthOfBinaryTree().new Solution();

          TreeNode root = new TreeNode(2,
                  null,
                  new TreeNode(3,
                          null,
                          new TreeNode(4,
                                  null,
                                  new TreeNode(5,
                                          null,
                                          new TreeNode(6)
                                  )
                          )
                  )
          );

          int i = solution.minDepth(root);
          System.out.println(i);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        //  1. 初始化核心数据结构
        //    a. 遍历队列
        Queue<TreeNode> q = new LinkedList<>();
        //    b. 标记数组（如果有环，有回头路的风险，树则不用这个标记数组。）
        q.offer(root);
        int depth = 1; // 默认 root 为第一层

        //  2. while 循环，从 start 开始，扩散寻找 target
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if (current.left == null && current.right == null){
                    return depth;
                }
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            depth++;
        }

        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }