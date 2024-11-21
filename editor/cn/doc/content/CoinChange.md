<p>给你一个整数数组 <code>coins</code> ，表示不同面额的硬币；以及一个整数 <code>amount</code> ，表示总金额。</p>

<p>计算并返回可以凑成总金额所需的 <strong>最少的硬币个数</strong> 。如果没有任何一种硬币组合能组成总金额，返回&nbsp;<code>-1</code> 。</p>

<p>你可以认为每种硬币的数量是无限的。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>coins = <span><code>[1, 2, 5]</code></span>, amount = <span><code>11</code></span>
<strong>输出：</strong><span><code>3</code></span> 
<strong>解释：</strong>11 = 5 + 5 + 1</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>coins = <span><code>[2]</code></span>, amount = <span><code>3</code></span>
<strong>输出：</strong>-1</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 0
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= coins.length &lt;= 12</code></li> 
 <li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li> 
 <li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 动态规划</details><br>

<div>👍 2930, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/dynamic-programming-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

1、**确定 base case**，显然目标金额 `amount` 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。

2、**确定「状态」，也就是原问题和子问题中会变化的变量**。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 `amount`。

3、**确定「选择」，也就是导致「状态」产生变化的行为**。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。

4、**明确 `dp` 函数/数组的定义**：输入一个目标金额 `n`，返回凑出目标金额 `n` 的最少硬币数量。

按照 `dp` 函数的定义描述「选择」，得到最终答案 `dp(amount)`。

**详细题解**：
  - [动态规划解题套路框架](https://labuladong.online/algo/essential-technique/dynamic-programming-framework/)

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
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    vector<int> memo;

    int coinChange(vector<int>& coins, int amount) {
        // dp 数组全都初始化为特殊值
        memo.resize(amount + 1, -666);
        return dp(coins, amount);
    }

    int dp(vector<int>& coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666)
            return memo[amount];

        int res = INT_MAX;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == INT_MAX) ? -1 : res;
        return memo[amount];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def __init__(self):
        self.memo = None

    def coinChange(self, coins: List[int], amount: int) -> int:
        self.memo = [-666] * (amount + 1)
        # dp 数组全都初始化为特殊值
        return self.dp(coins, amount)

    def dp(self, coins, amount):
        if amount == 0:
            return 0
        if amount < 0:
            return -1
        # 查备忘录，防止重复计算
        if self.memo[amount] != -666:
            return self.memo[amount]

        res = float('inf')
        for coin in coins:
            # 计算子问题的结果
            subProblem = self.dp(coins, amount - coin) # <extend up -200>![](https://labuladong.online/algo/images/动态规划详解进阶/5.jpg) #
            # 子问题无解则跳过
            if subProblem == -1:
                continue
            # 在子问题中选择最优解，然后加一
            res = min(res, subProblem + 1)

        # 把计算结果存入备忘录
        self.memo[amount] = -1 if res == float('inf') else res
        return self.memo[amount]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // dp 数组全都初始化为特殊值
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);/**<extend up -200>![](https://labuladong.online/algo/images/动态规划详解进阶/5.jpg) */
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func coinChange(coins []int, amount int) int {
    memo := make([]int, amount+1)
    // dp 数组全都初始化为特殊值
    for i := range memo {
        memo[i] = -666
    }
    return dp(coins, amount, memo)
}

func dp(coins []int, amount int, memo []int) int {
    if amount == 0 {
        return 0
    }
    if amount < 0 {
        return -1
    }
    // 查备忘录，防止重复计算
    if memo[amount] != -666 {
        return memo[amount]
    }

    res := math.MaxInt32
    for _, coin := range coins {
        // 计算子问题的结果
        subProblem := dp(coins, amount-coin, memo)
        // 子问题无解则跳过
        if subProblem == -1 {
            continue
        }
        // 在子问题中选择最优解，然后加一
        res = min(res, subProblem+1)
    }
    // 把计算结果存入备忘录
    memo[amount] = -1
    if res != math.MaxInt32 {
        memo[amount] = res
    }
    return memo[amount]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var coinChange = function(coins, amount) {
    // dp 数组全都初始化为特殊值
    let memo = new Array(amount + 1).fill(-666);
    // @visualize status(amount)
    var dp = function(amount) {
        if (amount === 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] !== -666)
            return memo[amount];

        let res = Number.MAX_VALUE;
        for (let coin of coins) {
            // 计算子问题的结果
            // @visualize choose(coin)
            let subProblem = dp(amount - coin);
            // @visualize unchoose()
            // 子问题无解则跳过
            if (subProblem === -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res === Number.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
    return dp(amount);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_coin-change" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_coin-change"></div></div>
</details><hr /><br />

</div>
</details>
</div>

