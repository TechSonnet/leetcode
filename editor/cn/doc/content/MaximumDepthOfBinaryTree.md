<p>给定一个二叉树 <code>root</code> ，返回其最大深度。</p>

<p>二叉树的 <strong>最大深度</strong> 是指从根节点到最远叶子节点的最长路径上的节点数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" /></p>

<p>&nbsp;</p>

<pre>
<b>输入：</b>root = [3,9,20,null,null,15,7]
<b>输出：</b>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>root = [1,null,2]
<b>输出：</b>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数量在&nbsp;<code>[0, 10<sup>4</sup>]</code>&nbsp;区间内。</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 1895, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

[我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解**：
  - [二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)

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

// **** 解法一，回溯算法思路 ****
class Solution {

public:
    int depth = 0;
    int res = 0;

    int maxDepth(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = max(res, depth);
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        depth--;
    }
};

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# **** 解法一，回溯算法思路 ****
class Solution:
    def __init__(self):
        self.depth = 0
        self.res = 0

    def maxDepth(self, root):
        self.traverse(root)
        return self.res

    # 遍历二叉树
    def traverse(self, root):
        if root is None:
            return

        # 前序遍历位置
        self.depth += 1
        # 遍历的过程中记录最大深度
        self.res = max(self.res, self.depth)
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.depth -= 1

# **** 解法二，动态规划思路 ****
class Solution2:
    # 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    def maxDepth(self, root):
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// **** 解法一，回溯算法思路 ****
class Solution {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// **** 解法一，回溯算法思路 ****
func maxDepth(root *TreeNode) int {
    var res int
    var depth int
    traverse(root, &depth, &res)
    return res
}

// 遍历二叉树
func traverse(root *TreeNode, depth *int, res *int) {
    if root == nil {
        return
    }

    // 前序遍历位置
    *depth++
    // 遍历的过程中记录最大深度
    if *depth > *res {
        *res = *depth
    }
    traverse(root.Left, depth, res)
    traverse(root.Right, depth, res)
    // 后序遍历位置
    *depth--
}

// **** 解法二，动态规划思路 ****
func maxDepthDP(root *TreeNode) int {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    if root == nil {
        return 0
    }
    leftMax := maxDepthDP(root.Left)
    rightMax := maxDepthDP(root.Right)
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + max(leftMax, rightMax)
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

/**
 * 解法一，回溯算法思路
 */
function maxDepth(root) {
    let depth = 0;
    let res = 0;
    // 遍历二叉树
    function traverse(root) {
        if (root === null) {
        return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
    traverse(root);
    return res;
}

/**
 * 解法二，动态规划思路
 */

// 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
function maxDepth2(root) {
    if (root === null) {
        return 0;
    }
    const leftMax = maxDepth2(root.left);
    const rightMax = maxDepth2(root.right);
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + Math.max(leftMax, rightMax);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_mydata-maxdepth1" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth1"></div></div>
</details><hr /><br />

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_mydata-maxdepth2" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth2"></div></div>
</details><hr /><br />

</div>
</details>
</div>

