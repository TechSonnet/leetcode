<p><strong>斐波那契数</strong>&nbsp;（通常用&nbsp;<code>F(n)</code> 表示）形成的序列称为 <strong>斐波那契数列</strong> 。该数列由&nbsp;<code>0</code> 和 <code>1</code> 开始，后面的每一项数字都是前面两项数字的和。也就是：</p>

<pre>
F(0) = 0，F(1)&nbsp;= 1
F(n) = F(n - 1) + F(n - 2)，其中 n &gt; 1
</pre>

<p>给定&nbsp;<code>n</code> ，请计算 <code>F(n)</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>1
<strong>解释：</strong>F(2) = F(1) + F(0) = 1 + 0 = 1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>2
<strong>解释：</strong>F(3) = F(2) + F(1) = 1 + 1 = 2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>3
<strong>解释：</strong>F(4) = F(3) + F(2) = 2 + 1 = 3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 30</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 记忆化搜索 | 数学 | 动态规划</details><br>

<div>👍 796, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/dynamic-programming-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题本身肯定是没有难度的，但是斐波那契数列可以帮你由浅入深理解动态规划算法的原理，建议阅读详细题解。

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

class Solution {
public:
    int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def fib(self, n: int) -> int:
        if n == 0 or n == 1:
            # base case
            return n
        # 分别代表 dp[i - 1] 和 dp[i - 2]
        dp_i_1 = 1
        dp_i_2 = 0
        for i in range(2, n + 1):
            # dp[i] = dp[i - 1] + dp[i - 2];
            dp_i = dp_i_1 + dp_i_2
            dp_i_2 = dp_i_1
            dp_i_1 = dp_i
        return dp_i_1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func fib(n int) int {
    if n == 0 || n == 1 {
        // base case
        return n
    }
    // 分别代表 dp[i - 1] 和 dp[i - 2]
    dp_i_1, dp_i_2 := 1, 0
    for i := 2; i <= n; i++ {
        // dp[i] = dp[i - 1] + dp[i - 2];
        dp_i := dp_i_1 + dp_i_2
        dp_i_2 = dp_i_1
        dp_i_1 = dp_i
    }
    return dp_i_1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var fib = function(n) {
    if (n === 0 || n === 1) {
        // base case
        return n;
    }
    // 分别代表 dp[i - 1] 和 dp[i - 2]
    let dp_i_1 = 1, dp_i_2 = 0;
    for (let i = 2; i <= n; i++) {
        // dp[i] = dp[i - 1] + dp[i - 2];
        let dp_i = dp_i_1 + dp_i_2;
        dp_i_2 = dp_i_1;
        dp_i_1 = dp_i;
    }
    return dp_i_1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_fibonacci-number" data="G/kYI5IsylwAdSbYzf54iUWIPU9T031xEZdhdqbLqnbl6mCi24GFSfJE9Ze2ZS0qfvATuujKXNNRZXUzEEHad60hWSSyeCwNGVcTBFHSHvcrgQtIUzYqV2aJZLvvJTslBJufX0BwhMIAWVch3Cm5e4/hVFf1Au0VOz62Dv+mIfI2T8P1OEhIJNTyafiHgWfKAtDgECSN9cV2flkNU+Sjlr/d+1guW+ur/1G6bYlNww6m+t+TWHWs+ZlyVCv8kfqqbVOPZbiktW4aNn2fNDoG551z1JLaEnz1ypxqufPYC17+/fa6XWMB2xf3H1gcJIBlb96YvrW1oUiGrExvMA3bNATJtfvcTGcBK2u66OZUhofEsl+O4iN4PVfsb60udYkxlO7xvmCylDR9pIgQI2OCNswQ3FnVj6MSqN6lBX1w+tMVo9j5xurnZV0wij5GjoBcbEz8ZkkSoTij21EFLz0Fe0l2RdFvEh2oHheBUvp0prkUoguvVp2yPypELarnUVBCq6McMPa0U8vJpB7YUkMXnJlgGloCeXVsTZZVZqgJ5EtxEOCoaWk6dVxTh2GfxI10RAUf+ijgZBaJncKSJ2+/tfZLvr799se6U0zbtHYqqYKgzKBOMlUuijWEpI84TCfRpWbCIBHo/NXGCmx7ZmtyiY97x5JSdjFZsDApLXEkrSxMSms2BU5NFO8FG5NSbE/MOi9MKQH6FKRl0X0p3+S05HwLFoXJKVtsRCnCpJQtlBOM0uQUm2LQ1oXpZnhkX4ryuPXUBvu/dp/N0xqGW+CIDlFZWvy5Gd0h30w/ECUVInZZ/MZUbaOY8u2p6ymeJMYn/6klgUBCPK4Glzqt8u70eP80XP/bvacvCO5WF97cRBtJA+oYt8kQoDjHvg4PhB/rvqlvJdyU2rTmIxpixvwbvfHKU7nACzBxs95hDRl7vu6pxpyfz8Z//mlRu3KhI0hwwCTOkVkaAhXiFFaZZCxig6ddeVNeKLY4Zn0RSwGhwnUuS1Ci0jPvtqAsg96mZ2SOB/lotNDu5FchbKCwwQp0K5aalQ9DUT02d2UqhJYlCBcUa9iYfedypfYcUCckZjPapoIB7Z0yULHEGc2RyIMXQELlCw3CgxeAY/Vbz5ShK1DBiMsCSYsBtT9aqS+fvwCrumY8KYyLEJ0CNdTT3PCAv78+lrjL4kGobQThRBRFOP/ykYy5SPOPWDfsjRyDphf3u4r8xAGPELmwEW70U2kBYyX8FX89VpHY4Nfq8MIf4QeDEDJpvgFlVetCiD5iEA5GIjMZetF3rVG0WGMkNJGRSwIPTyO1LevcCzagrgRG9fCnvN7UHmHGg13H+VzzytsuaNCBme7SI13kY4mQs+qFuU8IlgRDCdHJe76qaOiIt+BAIB6cFrzmN7SIzIgobJYRww5OUJYCjerbIYMIa+A5l3tx7gGD+3QBFnDCJ7XjnUdF0HW58/txcs8oq4Pq/wIDp2m7lsxA5Nz499fHBqZNUAgn9ycRAaVlWxWQsk1oSOOpGYIUtpQtdZgttpOy/YYNwXWcTUK+Jwg571dZ48u7vUR52L+PixVKdzduBkZkt6O4e6msjodmc5WPXWlhWPVsw3/QPKoykLoq8AX2uNvws9WZM+/Rk7tS5VFN7k4lrFTndy6n0zRt5mQeX/mc948avX63gSyJnpXWsy+PhCB/f1/1+9W3bEf/cJYYwwfwIzQPHjww1vz/b56eg1Jullwu18qFSu6DnKXLt5tZJqfl0L931+Y+d/N+x8mv6+dxNVcGZ3N/r1xDs64KbYvmEuMVA6StRpgXnP4lH5qUw9p95oFBeF5I863b9NfgC+rsFbKYbh7Ouq0Ktxufz34V6+6dPXDEOef63Bt8SSJquRjs3DD/3Pq47lXihcFlMRqQDGBf55z9QaIWz9i3Isx5ELdbD3K8SWbuukW2vrjm6w+8RJG5GLV2V1sy/zmOFiTOMKIjwOiedaQWSBiIgBSHsYtRgWFb5nkfAA==" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_fibonacci-number"></div></div>
</details><hr /><br />

</div>
</details>
</div>

