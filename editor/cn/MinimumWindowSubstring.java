  //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 3047, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.util.HashMap;

  public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();

           String s = "ADOBECODEBANC", t = "ABC";
          String res = solution.minWindow(s, t);
          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        // 1. 选定记录窗口的数据结构
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // 构造出了标准答案
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        // 2. 当窗口为扫描完毕时：
        int left = 0, right = 0;
        int valid = 0;
        int start = 0,  len = Integer.MAX_VALUE;
        while (right < s.length()){
            //  a. 扩大窗口，找到一个答案
            char c1 = s.charAt(right);
            if(need.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0) + 1);
                if (window.get(c1).equals(need.get(c1))){
                    valid++;
                }
            }
            right++; // 扩大窗口

            //  b. 缩小窗口，看是否为最优答案
            while (need.size() == valid){
                if(len > right - left){
                    start = left;
                    len = right - start;
                }

                char c2 = s.charAt(left);
                left++; // 收缩窗口

                if (need.containsKey(c2)){
                    if(need.get(c2).equals(window.get(c2))){
                        valid--;
                    }
                    window.put(c2,window.get(c2)-1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }