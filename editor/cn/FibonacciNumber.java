  //斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics递归 | 记忆化搜索 | 数学 | 动态规划 
//
// 👍 796, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;
  public class FibonacciNumber{
      public static void main(String[] args) {
           Solution solution = new FibonacciNumber().new Solution();

          System.out.println(solution.fib(5));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {

        int[] memo = new int[n+1];

        return dp(memo, n);
    }

    private int dp(int[] memo, int n){

        // 1. 设置递归出口
        if(n == 0 || n == 1) return n;

        // 2. 设置备忘录出口
        if(memo[n] != 0) return memo[n];

        // 3. 状态转移方程
        memo[n] = dp(memo,n-1) + dp(memo, n-2);

        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }