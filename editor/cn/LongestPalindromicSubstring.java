  //给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics双指针 | 字符串 | 动态规划 
//
// 👍 7418, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.nio.charset.StandardCharsets;

  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();

          String str = solution.longestPalindrome("cbbd");
          System.out.println(str);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        // 1. 实现中心扩散法的子函数，用于寻找以当前元素为中心的最长子串
        //   a. 奇数个元素，从 length/2 + 1 处向两边扫描
        //   b. 偶数个元素，从 length/2 和 length/2 + 1 处向两边扫描
        //   c. 左右指针开始扫描，直到两指针指向的元素不相等，返回该子串
        // 2. 对于字符串中的每一个元素，调用子函数寻找最长回文串，并记录起始位置和长度
         String s1 = "", s2 = "", res  =  "";

         for (int i = 0; i < s.length(); i++){

             s1 = getPalindrome(s, i, i + 1);
             s2 = getPalindrome(s, i, i);

//             if(res.length() < s1.length()){
//                 res = s1;
//             } else if(res.length() < s2.length()){
//                 res = s2;
//             }

             // 上方 if-else 的优化
             res = (res.length() < s1.length() ? s1:res);
             res = (res.length() < s2.length() ? s2:res);

        }

        return res;
    }

    public String getPalindrome(String s, int left, int right){
        if (s.isEmpty()) return "";

//       while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//               left--;
//               right++;
//       }

        // 对比上方的 while，显然上方的代码 更简洁
        while (left >=0 && right < s.length()){
            if (s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            } else { // 必须有此跳出循环的步骤，否则 cbbd 会死循环
                break;
            }

        }

       return s.substring(left + 1,right);

    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }