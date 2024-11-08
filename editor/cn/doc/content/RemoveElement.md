<p>给你一个数组 <code>nums</code><em>&nbsp;</em>和一个值 <code>val</code>，你需要 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong> 移除所有数值等于&nbsp;<code>val</code><em>&nbsp;</em>的元素。元素的顺序可能发生改变。然后返回&nbsp;<code>nums</code>&nbsp;中与&nbsp;<code>val</code>&nbsp;不同的元素的数量。</p>

<p>假设 <code>nums</code> 中不等于 <code>val</code> 的元素数量为 <code>k</code>，要通过此题，您需要执行以下操作：</p>

<ul> 
 <li>更改 <code>nums</code> 数组，使 <code>nums</code> 的前 <code>k</code> 个元素包含不等于 <code>val</code> 的元素。<code>nums</code> 的其余元素和 <code>nums</code> 的大小并不重要。</li> 
 <li>返回 <code>k</code>。</li> 
</ul>

<p><strong>用户评测：</strong></p>

<p>评测机将使用以下代码测试您的解决方案：</p>

<pre>
int[] nums = [...]; // 输入数组
int val = ...; // 要移除的值
int[] expectedNums = [...]; // 长度正确的预期答案。
                            // 它以不等于 val 的值排序。

int k = removeElement(nums, val); // 调用你的实现

assert k == expectedNums.length;
sort(nums, 0, k); // 排序 nums 的前 k 个元素
for (int i = 0; i &lt; actualLength; i++) {
    assert nums[i] == expectedNums[i];
}</pre>

<p>如果所有的断言都通过，你的解决方案将会 <strong>通过</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,2,3], val = 3
<strong>输出：</strong>2, nums = [2,2,_,_]
<strong>解释：</strong>你的函数函数应该返回 k = 2, 并且 nums<em> </em>中的前两个元素均为 2。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,2,2,3,0,4,2], val = 2
<strong>输出：</strong>5, nums = [0,1,4,0,3,_,_,_]
<strong>解释：</strong>你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
注意这五个元素可以任意顺序返回。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 100</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 50</code></li> 
 <li><code>0 &lt;= val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2341, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

类似 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)，需要使用 [双指针技巧](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中的快慢指针：

如果 `fast` 遇到需要去除的元素，则直接跳过，否则就告诉 `slow` 指针，并让 `slow` 前进一步。

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

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fast, slow = 0, 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func removeElement(nums []int, val int) int {
    slow := 0
    for fast := 0; fast < len(nums); fast++ {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var removeElement = function(nums, val) {
    let fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_remove-element" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-element"></div></div>
</details><hr /><br />

</div>
</details>
</div>

