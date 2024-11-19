<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong><span data-keyword="anagram">异位词</span>&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "cbaebabacd", p = "abc"
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "abab", p = "ab"
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 1535, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题和 [567. 字符串的排列](/problems/permutation-in-string) 一样，只不过找到一个合法异位词（排列）之后将它的起始索引加入结果列表即可。

滑动窗口算法难度略高，具体的算法原理以及算法模板见详细题解。

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

#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string t) {
        unordered_map<char, int> need;
        unordered_map<char, int> window;
        for (char c : t) {
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        vector<int> res;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.push_back(left);
                }
                char d = s[left];
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
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

from collections import deque, Counter
from typing import List

class Solution:
    # 查找字符串中所有字母异位词
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        p_count = Counter(p)
        s_count = Counter()
        
        # 滑动窗口模板
        for i in range(len(s)):
            # 扩大窗口，更新窗口最值
            s_count[s[i]] += 1
            if i >= len(p):
                # 缩小窗口，更新窗口最值
                if s_count[s[i - len(p)]] == 1:
                    del s_count[s[i - len(p)]]
                else:
                    s_count[s[i - len(p)]] -= 1
            # 在窗口收缩判断完之后才更新答案
            if s_count == p_count:
                res.append(i - len(p) + 1)
        return res

class MonotonicQueue:
    # 单调队列的通用实现，可以高效维护最大值和最小值
    # 由于我这里考虑了泛型和通用性，所以提交的性能会略差，你可自行精简
    def __init__(self):
        self.deque = deque()
    
    def push(self, value: int):
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)
    
    def pop(self, value: int):
        if self.deque and self.deque[0] == value:
            self.deque.popleft()
    
    def max(self) -> int:
        return self.deque[0]
    
    def min(self) -> int:
        return self.deque[-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
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
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func findAnagrams(s string, t string) []int {
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c] = need[c] + 1
    }

    left, right, valid := 0, 0, 0
    // 记录结果
    res := []int{}
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c] = window[c] + 1
            if window[c] == need[c] {
                valid++
            }
        }
        // 判断左侧窗口是否要收缩
        for right-left >= len(t) {
            // 当窗口符合条件时，把起始索引加入 res
            if valid == len(need) {
                res = append(res, left)
            }
            d := rune(s[left])
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
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var findAnagrams = function(s, t) {
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录结果
    let res = [];
    while (right < s.length) {
        let c = s[right];
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
            // 当窗口符合条件时，把起始索引加入 res
            if (valid === need.size) {
                res.push(left);
            }
            let d = s[left];
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
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_find-all-anagrams-in-a-string" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-anagrams-in-a-string"></div></div>
</details><hr /><br />

</div>
</details>
</div>

