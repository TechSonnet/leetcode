<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li> 
 <li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
<strong>解释：</strong>最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
<strong>解释：</strong>整个字符串 s 是最小覆盖子串。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code><sup>m == s.length</sup></code></li> 
 <li><code><sup>n == t.length</sup></code></li> 
 <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> 和 <code>t</code> 由英文字母组成</li> 
</ul>

<p>&nbsp;</p> 
<strong>进阶：</strong>你能设计一个在 
<code>o(m+n)</code> 时间内解决此问题的算法吗？

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 3047, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：

```java
int left = 0, right = 0;

while (right < nums.size()) {
    // 增大窗口
    window.addLast(nums[right]);
    right++;
    
    while (window needs shrink) {
        // 缩小窗口
        window.removeFirst(nums[left]);
        left++;
    }
}
```

具体的算法原理看详细题解吧，这里写不下。

**详细题解**：
  - [滑动窗口算法核心代码模板](https://labuladong.online/algo/essential-technique/sliding-window-framework/)

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

class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) {
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = INT_MAX;

        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        // 返回最小覆盖子串
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 记录前缀和
    # 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        
        from collections import Counter
        
        # Create a map to count all characters in t
        map_t = Counter(t)
        required = len(t)
        
        left = 0
        right = 0
        min_len = float("inf")
        min_start = 0
        
        while right < len(s):
            char_right = s[right]
            if char_right in map_t:
                if map_t[char_right] > 0:
                    required -= 1
                map_t[char_right] -= 1
            right += 1
            
            while required == 0:
                # 前序遍历位置
                if right - left < min_len:
                    min_len = right - left
                    min_start = left
                
                char_left = s[left]
                if char_left in map_t:
                    map_t[char_left] += 1
                    if map_t[char_left] > 0:
                        required += 1
                left += 1
        
        # 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        # 就是路径和为 targetSum 的路径条数
        # 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数

        # 后序遍历位置
        return "" if min_len == float("inf") else s[min_start:min_start + min_len]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func minWindow(s string, t string) string {
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c] = need[c] + 1
    }

    left, right := 0, 0
    valid := 0
    // 记录最小覆盖子串的起始索引及长度
    start, length := 0, int(^uint(0) >> 1)

    for right < len(s) {
        // c 是将移入窗口的字符
        c := rune(s[right])
        // 右移窗口
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c] = window[c] + 1
            if window[c] == need[c] {
                valid++
            }
        }

        // 判断左侧窗口是否要收缩
        for valid == len(need) {
            // 在这里更新最小覆盖子串
            if right-left < length {
                start = left
                length = right - left
            }
            // d 是将移出窗口的字符
            d := rune(s[left])
            // 左移窗口
            left++
            // 进行窗口内数据的一系列更新
            if _, ok := need[d]; ok {
                if window[d] == need[d] {
                    valid--
                }
                window[d] = window[d] - 1
            }
        }
    }

    // 返回最小覆盖子串
    if length == int(^uint(0)>>1) {
        return ""
    }
    return s[start : start+length]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var minWindow = function(s, t) {
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录最小覆盖子串的起始索引及长度
    let start = 0, len = Infinity;

    while (right < s.length) {
        // c 是将移入窗口的字符
        let c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }

        // 判断左侧窗口是否要收缩
        while (valid === need.size) {
            // 在这里更新最小覆盖子串
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            // d 是将移出窗口的字符
            let d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }
        }
    }
    // 返回最小覆盖子串
    return len === Infinity ? "" : s.substring(start, start + len);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_minimum-window-substring" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-window-substring"></div></div>
</details><hr /><br />

</div>
</details>
</div>

