<p>给你一个按照非递减顺序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。请你找出给定目标值在数组中的开始位置和结束位置。</p>

<p>如果数组中不存在目标值 <code>target</code>，返回&nbsp;<code>[-1, -1]</code>。</p>

<p>你必须设计并实现时间复杂度为&nbsp;<code>O(log n)</code>&nbsp;的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 8
<strong>输出：</strong>[3,4]</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 6
<strong>输出：</strong>[-1,-1]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [], target = 0
<strong>输出：</strong>[-1,-1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li> 
 <li><code>nums</code>&nbsp;是一个非递减数组</li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 2826, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-search-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

二分搜索的难点就在于如何搜索左侧边界和右侧边界，代码的边界的控制非常考验你的微操，这也是很多人知道二分搜索原理但是很难写对代码的原因。

[二分搜索框架详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 专门花了很大篇幅讨论如何写对二分搜索算法，总结来说：

写对二分搜索的关键在于搞清楚搜索边界，到底是开区间还是闭区间？到底应该往左侧收敛还是应该往右侧收敛？

深入的探讨请看详细题解。

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
    vector<int> searchRange(vector<int>& nums, int target) {
        return {left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.size() || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.left_bound(nums, target), self.right_bound(nums, target)]

    def left_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        # 搜索区间为 [left, right]
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                # 搜索区间变为 [mid+1, right]
                left = mid + 1
            elif nums[mid] > target:
                # 搜索区间变为 [left, mid-1]
                right = mid - 1
            elif nums[mid] == target:
                # 收缩右侧边界
                right = mid - 1
        # 检查出界情况
        if left >= len(nums) or nums[left] != target: # <extend up -300>![](https://labuladong.online/algo/images/binary-search/2.jpg) #
            return -1
        return left

    def right_bound(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            elif nums[mid] == target:
                # 这里改成收缩左侧边界即可
                left = mid + 1
        # 这里改为检查 right 越界的情况，见下图
        if right < 0 or nums[right] != target: # <extend up -300>![](https://labuladong.online/algo/images/binary-search/4.jpg) #
            return -1
        return right
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {/**<extend up -300>![](https://labuladong.online/algo/images/binary-search/2.jpg) */
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {/**<extend up -300>![](https://labuladong.online/algo/images/binary-search/4.jpg) */
            return -1;
        }
        return right;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// leftBound 查找左侧边界
// find the left boundary
func leftBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    // 搜索区间为 [left, right]
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            // 搜索区间变为 [mid+1, right]
            left = mid + 1
        } else if nums[mid] > target {
            // 搜索区间变为 [left, mid-1]
            right = mid - 1
        } else {
            // 收缩右侧边界
            right = mid - 1
        }
    }
    // 检查出界情况
    if left >= len(nums) || nums[left] != target {
        return -1
    }
    return left
}

// rightBound 查找右侧边界
// find the right boundary
func rightBound(nums []int, target int) int {
    left, right := 0, len(nums)-1
    // 搜索区间为 [left, right]
    for left <= right {
        mid := left + (right-left)/2
        if nums[mid] < target {
            left = mid + 1
        } else if nums[mid] > target {
            right = mid - 1
        } else {
            // 这里改成收缩左侧边界即可
            left = mid + 1
        }
    }
    // 这里改为检查 right 越界的情况，见下图
    if right < 0 || nums[right] != target {
        return -1
    }
    return right
}

// searchRange 查找目标值的范围
// find the range of the target value
func searchRange(nums []int, target int) []int {
    return []int{leftBound(nums, target), rightBound(nums, target)}
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var searchRange = function(nums, target) {
    // 返回目标值的搜索范围
    return [left_bound(nums, target), right_bound(nums, target)];
};

function left_bound(nums, target) {
    let left = 0, right = nums.length - 1;
    // 搜索区间为 [left, right]
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] < target) {
            // 搜索区间变为 [mid+1, right]
            left = mid + 1;
        } else if (nums[mid] > target) {
            // 搜索区间变为 [left, mid-1]
            right = mid - 1;
        } else if (nums[mid] === target) {
            // 收缩右侧边界
            right = mid - 1;
        }
    }
    // 检查出界情况
    if (left >= nums.length || nums[left] !== target) {
        return -1;
    }
    return left;
}

function right_bound(nums, target) {
    let left = 0, right = nums.length - 1;
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] === target) {
            // 这里改成收缩左侧边界即可
            left = mid + 1;
        }
    }
    // 这里改为检查 right 越界的情况，见下图
    if (right < 0 || nums[right] !== target) {
        return -1;
    }
    return right;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_find-first-and-last-position-of-element-in-sorted-array" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-first-and-last-position-of-element-in-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>



