<p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的 <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>

<p><br> <strong>示例 1:</strong></br></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 9
<strong>输出:</strong> 4
<strong>解释:</strong> 9 出现在 <span><code>nums</code></span> 中并且下标为 4
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 2
<strong>输出:</strong> -1
<strong>解释:</strong> 2 不存在 <span><code>nums</code></span> 中因此返回 -1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li> 
 <li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li> 
 <li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li> 
</ol>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 1648, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-search-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

二分搜索的基本形式，不过并不实用，比如 `target` 重复出现多次，本算法得出的索引位置是不确定的。

更常见的二分搜索形式是搜索左侧边界和右侧边界，即对于 `target` 重复出现多次的情景，计算 `target` 的最小索引和最大索引。

这几种二分搜索的形式的详细探讨见详细题解。

**详细题解**：
  - [二分搜索算法核心代码模板](https://labuladong.online/algo/essential-technique/binary-search-framework/)

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
    int search(vector<int>& nums, int target) {
        int left = 0;
        // 注意
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                // 注意
                left = mid + 1;
            else if (nums[mid] > target)
                // 注意
                right = mid - 1;
        }
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        # 注意
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                # 注意
                left = mid + 1
            else:
                # 注意
                right = mid - 1
        return -1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        // 注意
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                // 注意
                left = mid + 1;
            else if (nums[mid] > target)
                // 注意
                right = mid - 1;
        }
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func search(nums []int, target int) int {
    left := 0
    // 注意
    right := len(nums) - 1

    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            // 注意
            left = mid + 1
        } else if nums[mid] > target {
            // 注意
            right = mid - 1
        }
    }
    return -1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var search = function(nums, target) {
    let left = 0;
    // 注意
    let right = nums.length - 1;

    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] === target)
            return mid;
        else if (nums[mid] < target)
            // 注意
            left = mid + 1;
        else if (nums[mid] > target)
            // 注意
            right = mid - 1;
    }
    return -1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_binary-search" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-search"></div></div>
</details><hr /><br />

</div>
</details>
</div>

