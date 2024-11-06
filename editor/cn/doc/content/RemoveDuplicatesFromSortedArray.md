<p>给你一个 <strong>非严格递增排列</strong> 的数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>只出现一次</strong> ，返回删除后数组的新长度。元素的 <strong>相对顺序</strong> 应该保持 <strong>一致</strong> 。然后返回 <code>nums</code> 中唯一元素的个数。</p>

<p>考虑 <code>nums</code> 的唯一元素的数量为 <code>k</code> ，你需要做以下事情确保你的题解可以被通过：</p>

<ul> 
 <li>更改数组 <code>nums</code> ，使 <code>nums</code> 的前 <code>k</code> 个元素包含唯一元素，并按照它们最初在 <code>nums</code> 中出现的顺序排列。<code>nums</code>&nbsp;的其余元素与 <code>nums</code> 的大小不重要。</li> 
 <li>返回 <code>k</code>&nbsp;。</li> 
</ul>

<p><strong>判题标准:</strong></p>

<p>系统会用下面的代码来测试你的题解:</p>

<pre>
int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}</pre>

<p>如果所有断言都通过，那么您的题解将被 <strong>通过</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,2]
<strong>输出：</strong>2, nums = [1,2,_]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>2</code></strong> ，并且原数组 <em>nums </em>的前两个元素被修改为 <strong><code>1</code></strong>, <strong><code>2 </code></strong><span><code>。</code></span>不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,2,2,3,3,4]
<strong>输出：</strong>5, nums = [0,1,2,3,4]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong> ， 并且原数组 <em>nums </em>的前五个元素被修改为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>2</code></strong>, <strong><code>3</code></strong>, <strong><code>4</code></strong> 。不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按 <strong>非严格递增</strong>&nbsp;排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 3669, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

有序序列去重的通用解法就是我们前文 [双指针技巧](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中的快慢指针技巧。

我们让慢指针 `slow` 走在后面，快指针 `fast` 走在前面探路，找到一个不重复的元素就告诉 `slow` 并让 `slow` 前进一步。这样当 `fast` 指针遍历完整个数组 `nums` 后，**`nums[0..slow]` 就是不重复元素**。

![](https://labuladong.online/algo/images/array-dedup/1.gif)

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

#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        slow = 0
        fast = 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                # 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast]
            fast += 1
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func removeDuplicates(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    slow, fast := 0, 0
    for fast < len(nums) {
        if nums[fast] != nums[slow] {
            slow++
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast]
        }
        fast++
    }
    // 数组长度为索引 + 1
    return slow + 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    let slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>

