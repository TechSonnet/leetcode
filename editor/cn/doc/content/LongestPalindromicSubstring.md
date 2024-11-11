<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的 <span data-keyword="palindromic-string">回文</span> <span data-keyword="substring-nonempty">子串</span>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> 仅由数字和英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串 | 动态规划</details><br>

<div>👍 7418, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

**寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串**，对于最长回文子串，就是这个意思：

```python
for 0 <= i < len(s):
    找到以 s[i] 为中心的回文串
    更新答案
```

找回文串的关键技巧是传入两个指针 `l` 和 `r` 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。

```python
for 0 <= i < len(s):
    # 找到以 s[i] 为中心的回文串
    palindrome(s, i, i)
    # 找到以 s[i] 和 s[i+1] 为中心的回文串
    palindrome(s, i, i + 1)
    更新答案
```

**详细题解**：
  - [双指针技巧秒杀七道数组题目](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            string s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            string s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

private:
    string palindrome(string s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s[l] == s[r]) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substr(l + 1, r - l - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # 以 s[i] 为中心的最长回文子串
            s1 = self.palindrome(s, i, i)
            # 以 s[i] 和 s[i+1] 为中心的最长回文子串
            s2 = self.palindrome(s, i, i + 1)
            # res = longest(res, s1, s2)
            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2
        return res

    def palindrome(self, s: str, l: int, r: int) -> str:
        # 防止索引越界
        while l >= 0 and r < len(s) and s[l] == s[r]:
            # 向两边展开
            l -= 1
            r += 1
        # 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s[l + 1:r]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func longestPalindrome(s string) string {
    res := ""
    for i := 0; i < len(s); i++ {
        // 以 s[i] 为中心的最长回文子串
        s1 := palindrome(s, i, i)
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        s2 := palindrome(s, i, i+1)
        // res = longest(res, s1, s2)
        if len(res) > len(s1) {
            res = res
        } else {
            res = s1
        }
        if len(res) > len(s2) {
            res = res
        } else {
            res = s2
        }
    }
    return res
}

func palindrome(s string, l, r int) string {
    // 防止索引越界
    for l >= 0 && r < len(s) && s[l] == s[r] {
        // 向两边展开
        l--
        r++
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s[l+1:r]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var longestPalindrome = function(s) {
    let res = "";
    for (let i = 0; i < s.length; i++) {
        // 以 s[i] 为中心的最长回文子串
        let s1 = palindrome(s, i, i);
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        let s2 = palindrome(s, i, i + 1);
        // res = longest(res, s1, s2)
        res = res.length > s1.length ? res : s1;
        res = res.length > s2.length ? res : s2;
    }
    return res;
};

var palindrome = function(s, l, r) {
    // 防止索引越界
    while (l >= 0 && r < s.length && s[l] === s[r]) {
        // 向两边展开
        l--;
        r++;
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s.substring(l + 1, r);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_longest-palindromic-substring" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-palindromic-substring"></div></div>
</details><hr /><br />

</div>
</details>
</div>

