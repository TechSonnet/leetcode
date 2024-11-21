<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 6</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2995, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 中就是拿这个问题来解释回溯模板的，首先画出回溯树来看一看：

![](https://labuladong.online/algo/images/subset/3.jpg)

写代码遍历这棵回溯树即可。

**详细题解**：
  - [回溯算法解题套路框架](https://labuladong.online/algo/essential-technique/backtrack-framework/)
  - [球盒模型：回溯算法穷举的两种视角](https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/)
  - [回溯算法秒杀所有排列/组合/子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <vector>
#include <list>

class Solution {

    std::vector<std::vector<int>> res;

public:
    // 主函数，输入一组不重复的数字，返回它们的全排列
    std::vector<std::vector<int>> permute(std::vector<int>& nums) {
        std::list<int> track; // 记录「路径」
        std::vector<bool> used(nums.size(), false); // 「路径」中的元素会被标记为 true，避免重复使用
        
        backtrack(nums, track, used);
        return res;
    }

private:
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(const std::vector<int>& nums, std::list<int>& track, std::vector<bool>& used) {
        // 触发结束条件
        if (track.size() == nums.size()) {
            res.push_back(std::vector<int>(track.begin(), track.end()));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push_back(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop_back();
            used[i] = false;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def __init__(self):
        self.res = []

    # 主函数，输入一组不重复的数字，返回它们的全排列
    def permute(self, nums):
        # 记录「路径」
        track = []
        # 「路径」中的元素会被标记为 true，避免重复使用
        used = [False] * len(nums)
        
        self.backtrack(nums, track, used)
        return self.res

    # 路径：记录在 track 中
    # 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    # 结束条件：nums 中的元素全都在 track 中出现
    def backtrack(self, nums, track, used):
        # 触发结束条件
        if len(track) == len(nums):
            self.res.append(track.copy())
            return

        for i in range(len(nums)):
            # 排除不合法的选择
            if used[i]: # <extend up -200>![](https://labuladong.online/algo/images/backtracking/6.jpg) #
                # nums[i] 已经在 track 中，跳过
                continue
            # 做选择
            track.append(nums[i])
            used[i] = True
            # 进入下一层决策树
            self.backtrack(nums, track, used)
            # 取消选择
            track.pop()
            used[i] = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    // 主函数，输入一组不重复的数字，返回它们的全排列
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.online/algo/images/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var res [][]int

// 主函数，输入一组不重复的数字，返回它们的全排列
func permute(nums []int) [][]int {
    res = [][]int{} // Initialize the result slice
    // 记录「路径」
    var track []int
    // 「路径」中的元素会被标记为 true，避免重复使用
    used := make([]bool, len(nums))

    backtrack(nums, track, used)
    return res
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
// 结束条件：nums 中的元素全都在 track 中出现
func backtrack(nums []int, track []int, used []bool) {
    // 触发结束条件
    if len(track) == len(nums) {
        newTrack := make([]int, len(track))
        copy(newTrack, track)
        res = append(res, newTrack)
        return
    }

    for i := 0; i < len(nums); i++ {
        // 排除不合法的选择
        if used[i] {
            // nums[i] 已经在 track 中，跳过
            continue
        }
        // 做选择
        track = append(track, nums[i])
        used[i] = true
        // 进入下一层决策树
        backtrack(nums, track, used)
        // 取消选择
        track = track[:len(track)-1]
        used[i] = false
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var permute = function(nums) {
    // 主函数，输入一组不重复的数字，返回它们的全排列
    let res = [];
    // 记录「路径」
    let track = [];
    // 「路径」中的元素会被标记为 true，避免重复使用
    let used = Array(nums.length).fill(false);

    // @visualize status(track)
    function backtrack(nums, track, used) {
        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
        // 结束条件：nums 中的元素全都在 track 中出现
        if (track.length === nums.length) {
            // 触发结束条件
            res.push([...track]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            // @visualize choose(nums[i])
            track.push(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            // @visualize unchoose()
            track.pop();
            used[i] = false;
        }
    }

    backtrack(nums, track, used);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_permutations" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutations"></div></div>
</details><hr /><br />

</div>
</details>
</div>

