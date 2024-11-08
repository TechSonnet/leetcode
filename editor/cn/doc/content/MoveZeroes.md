<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0,1,0,3,12]</code></span>
<strong>输出:</strong> <span><code>[1,3,12,0,0]</code></span>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0]</code></span>
<strong>输出:</strong> <span><code>[0]</code></span></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2484, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

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
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
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
    def moveZeroes(self, nums):
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0

    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums, val):
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
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
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

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast, slow := 0, 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
    
    // 双指针技巧，复用 [27. 移除元素] 的解法。
    function removeElement(nums, val) {
        let fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] !== val) {
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
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_move-zeroes" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

</div>
</details>
</div>

