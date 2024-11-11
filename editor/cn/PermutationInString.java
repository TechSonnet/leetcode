  //给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 1034, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.util.HashMap;

  public class PermutationInString{
      public static void main(String[] args) {
           Solution solution = new PermutationInString().new Solution();

            String s1 = "hello" , s2 = "ooolleoooleh";
//           String s1= "ab" , s2 = "eidboaoo";
          System.out.println(solution.checkInclusion(s1, s2));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // 1. 选择两个 map 作为记录窗口的数据结构
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 2. 右指针扫描整个字符串，当未扫描完毕时，执行一下两步：
        //   a. 找到一个答案范围,该窗口包含对应的元素
        //   b. 确定答案范围的最优解,判断是否只包含子串，如校验长度
        int left = 0, right = 0;
        int valid = 0;
//        int start = 0, len = 0;
        while (right < s2.length()){

            char c1 = s2.charAt(right);
            right++;

            if(need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if(need.get(c1).equals(window.get(c1))){
                    valid++;
                }
            }

            while ((right - left) >= s1.length() ) { // 包含子串所有元素

                if(valid == need.size()){
                    return true;
                }

                char c2 = s2.charAt(left);
                left++;

                if(need.containsKey(c2)){
                    if ( need.get(c2).equals(window.get(c2))){
                        valid--;
                    }
                    window.put(c2,window.get(c2)-1);
                }

            }

        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }