<p>给你两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code> ，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的 <span data-keyword="permutation-string">排列</span>。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>换句话说，<code>s1</code> 的排列之一是 <code>s2</code> 的 <strong>子串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s1 = "ab" s2 = "eidbaooo"
<strong>输出：</strong>true
<strong>解释：</strong>s2 包含 s1 的排列之一 ("ba").
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s1= "ab" s2 = "eidboaoo"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>

<div>👍 1034, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

和子数组/子字符串相关的题目，很可能就是要考察滑动窗口算法，往这方面思考就行了。

这道题，相当于你一个 `S` 和一个 `T`，请问你 `S` 中是否存在一个子串，包含 `T` 中所有字符且不包含其他字符？

如果这样想的话就和 [76. 最小覆盖子串](/problems/minimum-window-substring) 有些类似了。

一般来说滑动窗口算法难度略高，需要你掌握算法原理以及算法模板辅助，见详细题解吧。

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
    // 判断 s 中是否存在 t 的排列
    bool checkInclusion(string t, string s) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 判断 s 中是否存在 t 的排列
    def checkInclusion(self, t: str, s: str) -> bool:
        need = {}
        window = {}
        for c in t:
            need[c] = need.get(c, 0) + 1

        left = 0
        right = 0
        valid = 0
        while right < len(s):
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                window[c] = window.get(c, 0) + 1
                if window[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否要收缩
            while right - left >= len(t):
                # 在这里判断是否找到了合法的子串
                if valid == len(need):
                    return True
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1

        # 未找到符合条件的子串
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 判断 s 中是否存在 t 的排列
    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func checkInclusion(t string, s string) bool {
    // 判断 s 中是否存在 t 的排列
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c]++
    }

    left, right := 0, 0
    valid := 0
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        if need[c] > 0 {
            window[c]++
            if window[c] == need[c] {
                valid++
            }
        }

        // 判断左侧窗口是否要收缩
        for right-left >= len(t) {
            // 在这里判断是否找到了合法的子串
            if valid == len(need) {
                return true
            }
            d := rune(s[left])
            left++
            // 进行窗口内数据的一系列更新
            if need[d] > 0 {
                if window[d] == need[d] {
                    valid--
                }
                window[d]--
            }
        }
    }
    // 未找到符合条件的子串
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var checkInclusion = function(t, s) {
    // 判断 s 中是否存在 t 的排列
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    while (right < s.length) {
        let c = s.charAt(right);
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }

        // 判断左侧窗口是否要收缩
        while (right - left >= t.length) {
            // 在这里判断是否找到了合法的子串
            if (valid === need.size) {
                return true;
            }
            let d = s.charAt(left);
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
    // 未找到符合条件的子串
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_permutation-in-string" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutation-in-string"></div></div>
</details><hr /><br />

</div>
</details>
</div>

