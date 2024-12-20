<p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>

<p>你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。</p>

<p>你可以按任意顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[0,1]
<strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,4], target = 6
<strong>输出：</strong>[1,2]
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,3], target = 6
<strong>输出：</strong>[0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
 <li><strong>只会存在一个有效答案</strong></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表</details><br>

<div>👍 19021, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/nsum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

大家都喜欢幽默的人，如果你想调侃自己经常拖延，可以这样调侃下自己（手动狗头）：

背单词背了半年还是 abandon, abandon，刷题刷了半年还是 two sum, two sum...

言归正传，这道题不难，但由于它是 LeetCode 第一题，所以名气比较大，解决这道题也可以有多种思路，我这里说两种最常见的思路。

第一种思路就是靠排序，把 `nums` 排序之后就可以用 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲到的左右指针来求出和为 `target` 的两个数。

不过因为题目要求我们返回元素的索引，而排序会破坏元素的原始索引，所以要记录值和原始索引的映射。

进一步，如果题目拓展延伸一下，让你求三数之和、四数之和，你依然可以用双指针技巧，我在 [一个函数秒杀 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/) 中写一个函数来解决所有 N 数之和问题。

第二种思路是用哈希表辅助判断。对于一个元素 `nums[i]`，你想知道有没有另一个元素 `nums[j]` 的值为 `target - nums[i]`，这很简单，我们用一个哈希表记录每个元素的值到索引的映射，这样就能快速判断数组中是否有一个值为 `target - nums[i]` 的元素了。

简单说，数组其实可以理解为一个「索引 -> 值」的哈希表映射，而我们又建立一个「值 -> 索引」的映射即可完成此题。

**详细题解**：
  - [一个方法团灭 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/)
  - [【强化练习】哈希表更多习题](https://labuladong.online/algo/problem-set/hash-table/)

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 维护 val -> index 的映射
        unordered_map<int, int> valToIndex;
        for (int i = 0; i < nums.size(); i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.find(need) != valToIndex.end()) {
                return {valToIndex[need], i};
            }
            // 存入 val -> index 的映射
            valToIndex[nums[i]] = i;
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 维护 val -> index 的映射
        val_to_index = {}
        for i in range(len(nums)):
            # 查表，看看是否有能和 nums[i] 凑出 target 的元素
            need = target - nums[i]
            if need in val_to_index:
                return [val_to_index[need], i]
            # 存入 val -> index 的映射
            val_to_index[nums[i]] = i
        return []
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func twoSum(nums []int, target int) []int {
    // 维护 val -> index 的映射
    valToIndex := make(map[int]int)
    for i, num := range nums {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        need := target - num
        if j, ok := valToIndex[need]; ok {
            return []int{j, i}
        }
        // 存入 val -> index 的映射
        valToIndex[num] = i
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var twoSum = function(nums, target) {
    // 维护 val -> index 的映射
    let valToIndex = new Map();
    for (let i = 0; i < nums.length; i++) {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        let need = target - nums[i];
        if (valToIndex.has(need)) {
            return [valToIndex.get(need), i];
        }
        // 存入 val -> index 的映射
        valToIndex.set(nums[i], i);
    }
    return null;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_two-sum" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_two-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>



