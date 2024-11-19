  //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1535, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.List;

  public class FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();

//           String s = "cbaebabacd", p = "abc";
          String s = "abab", p = "ab";
          List<Integer> list = solution.findAnagrams(s, p);

          for (Integer i : list) {
              System.out.println(i);
          }

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {


        // 1. 设置两个数据结构，need 和 Window，用于记录目标数据和窗口数据
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        // 2. 设置两个指针，当右指针未到达字符串尾元素时
        int left = 0, right = 0;
        int valid = 0;

        //  a. 右指针移动，扩大窗口，当窗口大小等于子串长度时
        while (right < s.length()){
            char c1 = s.charAt(right);
            right++;

            if (need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (need.get(c1).equals(window.get(c1))){
                    valid++;
                }
            }

            //  b. 判断一下是否符合异位词的要求
            while ((right - left) >= p.length()) {
                if(valid == need.size()){
                    res.add(left);
                }

                char c2 = s.charAt(left);
                left++;

                if (need.containsKey(c2)){
                    if (need.get(c2).equals(window.get(c2))){
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }