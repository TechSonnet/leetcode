<p>给定一个二叉树，找出其最小深度。</p>

<p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。</p>

<p><strong>说明：</strong>叶子节点是指没有子节点的节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [2,null,3,null,4,null,5,null,6]
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数的范围在 <code>[0, 10<sup>5</sup>]</code> 内</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 1243, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价，有需要可以尽快购买/续费，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/bfs-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题可以同时运用两种思维，而且还可以用 BFS 层序遍历的方式求解，我会给出三种解法。

希望大家借助这道题仔细理解二叉树和 [BFS 算法](https://labuladong.online/algo/essential-technique/bfs-framework/)、[动态规划算法](https://labuladong.online/algo/essential-technique/dynamic-programming-framework/)、[回溯算法](https://labuladong.online/algo/essential-technique/backtrack-framework/) 的联系。

**详细题解**：
  - [BFS 算法解题套路框架](https://labuladong.online/algo/essential-technique/bfs-framework/)

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

// 「遍历」的递归思路
class Solution {
private:
    int minDepthValue = INT_MAX;
    int currentDepth = 0;

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 做选择：在进入节点时增加当前深度
        currentDepth++;

        // 如果当前节点是叶子节点，更新最小深度
        if (root->left == nullptr && root->right == nullptr) {
            minDepthValue = std::min(minDepthValue, currentDepth);
        }

        traverse(root->left);
        traverse(root->right);

        // 撤销选择：在离开节点时减少当前深度
        currentDepth--;
    }

public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        traverse(root);
        return minDepthValue;
    }
};

// 「分解问题」的递归思路
class Solution2 {
public:
    int minDepth(TreeNode* root) {
        // 基本情况：如果节点为空，返回深度为0
        if (root == nullptr) {
            return 0;
        }

        // 递归计算左子树的最小深度
        int leftDepth = minDepth(root->left);
        // 递归计算右子树的最小深度
        int rightDepth = minDepth(root->right);

        // 特殊情况处理：如果左子树为空，返回右子树的深度加1
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        // 特殊情况处理：如果右子树为空，返回左子树的深度加1
        if (rightDepth == 0) {
            return leftDepth + 1;
        }

        // 计算并返回最小深度：左右子树深度的最小值加1
        return std::min(leftDepth, rightDepth) + 1;
    }
};

// BFS 的思路
class Solution3 {
public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        std::queue<TreeNode*> q;
        q.push(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.empty()) {
            int sz = q.size();
            // 遍历当前层的节点
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                // 判断是否到达叶子结点
                if (cur->left == nullptr && cur->right == nullptr)
                    return depth;
                // 将下一层节点加入队列
                if (cur->left != nullptr)
                    q.push(cur->left);
                if (cur->right != nullptr)
                    q.push(cur->right);
            }
            // 这里增加步数
            depth++;
        }
        return depth;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 「遍历」的递归思路
class Solution:
    def __init__(self):
        self.minimumDepth = float('inf')
        self.currentDepth = 0

    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        self.traverse(root)
        return self.minimumDepth

    def traverse(self, root: TreeNode):
        if root is None:
            return

        # 做选择：在进入节点时增加当前深度
        self.currentDepth += 1

        # 如果当前节点是叶子节点，更新最小深度
        if root.left is None and root.right is None:
            self.minimumDepth = min(self.minimumDepth, self.currentDepth)

        self.traverse(root.left)
        self.traverse(root.right)

        # 撤销选择：在离开节点时减少当前深度
        self.currentDepth -= 1


# 「分解问题」的递归思路
class Solution2:
    def minDepth(self, root: TreeNode) -> int:
        # 基本情况：如果节点为空，返回深度为0
        if root is None:
            return 0

        # 递归计算左子树的最小深度
        leftDepth = self.minDepth(root.left)
        # 递归计算右子树的最小深度
        rightDepth = self.minDepth(root.right)

        # 特殊情况处理：如果左子树为空，返回右子树的深度加1
        if leftDepth == 0:
            return rightDepth + 1
        # 特殊情况处理：如果右子树为空，返回左子树的深度加1
        if rightDepth == 0:
            return leftDepth + 1

        # 计算并返回最小深度：左右子树深度的最小值加1
        return min(leftDepth, rightDepth) + 1


# BFS 的思路
from collections import deque

class Solution3:
    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        q = deque([root])
        # root 本身就是一层，depth 初始化为 1
        depth = 1

        while q: # <extend down -200>![](https://labuladong.online/algo/images/dijkstra/1.jpeg) #
            sz = len(q)
            # 遍历当前层的节点
            for i in range(sz):
                cur = q.popleft()
                # 判断是否到达叶子结点
                if cur.left is None and cur.right is None:
                    return depth
                # 将下一层节点加入队列
                if cur.left is not None:
                    q.append(cur.left)
                if cur.right is not None:
                    q.append(cur.right)
            # 这里增加步数
            depth += 1
        return depth
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 「遍历」的递归思路
class Solution {
    private int minDepth = Integer.MAX_VALUE;
    private int currentDepth = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return minDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 做选择：在进入节点时增加当前深度
        currentDepth++;

        // 如果当前节点是叶子节点，更新最小深度
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
        }

        traverse(root.left);
        traverse(root.right);

        // 撤销选择：在离开节点时减少当前深度
        currentDepth--;
    }
}

// 「分解问题」的递归思路
class Solution2 {
    public int minDepth(TreeNode root) {
        // 基本情况：如果节点为空，返回深度为0
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的最小深度
        int leftDepth = minDepth(root.left);
        // 递归计算右子树的最小深度
        int rightDepth = minDepth(root.right);

        // 特殊情况处理：如果左子树为空，返回右子树的深度加1
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        // 特殊情况处理：如果右子树为空，返回左子树的深度加1
        if (rightDepth == 0) {
            return leftDepth + 1;
        }

        // 计算并返回最小深度：左右子树深度的最小值加1
        return Math.min(leftDepth, rightDepth) + 1;
    }
}


// BFS 的思路
class Solution3 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {/**<extend down -200>![](https://labuladong.online/algo/images/dijkstra/1.jpeg) */
            int sz = q.size();
            // 遍历当前层的节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 判断是否到达叶子结点
                if (cur.left == null && cur.right == null)
                    return depth;
                // 将下一层节点加入队列
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            // 这里增加步数
            depth++;
        }
        return depth;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 「遍历」的递归思路
func minDepth(root *TreeNode) int {
    minDepth := int(^uint(0) >> 1) // Initialize to maximum integer
    var currentDepth int
    if root == nil {
        return 0
    }
    traverse(root, &currentDepth, &minDepth)
    return minDepth
}

func traverse(root *TreeNode, currentDepth, minDepth *int) {
    if root == nil {
        return
    }

    // 做选择：在进入节点时增加当前深度
    *currentDepth++

    // 如果当前节点是叶子节点，更新最小深度
    if root.Left == nil && root.Right == nil {
        if *currentDepth < *minDepth {
            *minDepth = *currentDepth
        }
    }

    traverse(root.Left, currentDepth, minDepth)
    traverse(root.Right, currentDepth, minDepth)

    // 撤销选择：在离开节点时减少当前深度
    *currentDepth--
}

// 「分解问题」的递归思路
func minDepth2(root *TreeNode) int {
    // 基本情况：如果节点为空，返回深度为0
    if root == nil {
        return 0
    }

    // 递归计算左子树的最小深度
    leftDepth := minDepth2(root.Left)
    // 递归计算右子树的最小深度
    rightDepth := minDepth2(root.Right)

    // 特殊情况处理：如果左子树为空，返回右子树的深度加1
    if leftDepth == 0 {
        return rightDepth + 1
    }
    // 特殊情况处理：如果右子树为空，返回左子树的深度加1
    if rightDepth == 0 {
        return leftDepth + 1
    }

    // 计算并返回最小深度：左右子树深度的最小值加1
    if leftDepth < rightDepth {
        return leftDepth + 1
    }
    return rightDepth + 1
}

// BFS 的思路
func minDepth3(root *TreeNode) int {
    if root == nil {
        return 0
    }
    queue := []*TreeNode{root}
    // root 本身就是一层，depth 初始化为 1
    depth := 1

    for len(queue) > 0 {
        sz := len(queue)
        // 遍历当前层的节点
        for i := 0; i < sz; i++ {
            cur := queue[0]
            queue = queue[1:]
            // 判断是否到达叶子结点
            if cur.Left == nil && cur.Right == nil {
                return depth
            }
            // 将下一层节点加入队列
            if cur.Left != nil {
                queue = append(queue, cur.Left)
            }
            if cur.Right != nil {
                queue = append(queue, cur.Right)
            }
        }
        // 这里增加步数
        depth++
    }
    return depth
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 「遍历」的递归思路
var minDepth = function(root) {
    let minDepth = Infinity;
    let currentDepth = 0;

    var traverse = function(root) {
        if (root === null) {
            return;
        }

        // 做选择：在进入节点时增加当前深度
        currentDepth++;

        // 如果当前节点是叶子节点，更新最小深度
        if (root.left === null && root.right === null) {
            minDepth = Math.min(minDepth, currentDepth);
        }

        traverse(root.left);
        traverse(root.right);

        // 撤销选择：在离开节点时减少当前深度
        currentDepth--;
    }

    if (root === null) {
        return 0;
    }
    traverse(root);
    return minDepth;
};

// 「分解问题」的递归思路
var minDepth2 = function(root) {
    // 基本情况：如果节点为空，返回深度为0
    if (root === null) {
        return 0;
    }

    // 递归计算左子树的最小深度
    let leftDepth = minDepth2(root.left);
    // 递归计算右子树的最小深度
    let rightDepth = minDepth2(root.right);

    // 特殊情况处理：如果左子树为空，返回右子树的深度加1
    if (leftDepth === 0) {
        return rightDepth + 1;
    }
    // 特殊情况处理：如果右子树为空，返回左子树的深度加1
    if (rightDepth === 0) {
        return leftDepth + 1;
    }

    // 计算并返回最小深度：左右子树深度的最小值加1
    return Math.min(leftDepth, rightDepth) + 1;
};

// BFS 的思路
var minDepth3 = function(root) {
    if (root === null) return 0;
    let q = [];
    q.push(root);
    // root 本身就是一层，depth 初始化为 1
    let depth = 1;

    while (q.length > 0) {
        let sz = q.length;
        // 遍历当前层的节点
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            // 判断是否到达叶子结点
            if (cur.left === null && cur.right === null)
                return depth;
            // 将下一层节点加入队列
            if (cur.left !== null)
                q.push(cur.left);
            if (cur.right !== null)
                q.push(cur.right);
        }
        // 这里增加步数
        depth++;
    }
    return depth;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_minimum-depth-of-binary-tree" data="G4xbIxHCxoEApP/fqKhZgxMvooKTAKhFgm0st+FbGAqTRDpvl403/+SqyeIIGXIb3GCYuqEN8M3P+e9Pq3lTaWBBSenNQxdEUMSac4dtSv7XZCZCcpts349wWkVpmhIyDVQ80gH+5ge3N+1GG5xbyHVXM/CfX+s1wBOCyUZIYKNQRQEpRJu999w5QZz9AVRMc9+b/dkNUVEBoKvwFaZKVlZWu/rfr/2qaPoNrWRCN08M3f/36asH0emESOiriEh0Cb0uL933FrwkSDvA//fLKVeCcK0dhEd4jGIw8v33uY5i6elqWRnZm8pEZaKYyPgylv6eRw/cblGEECHtnwntvo2lHmkM3a8MIafYNY7Xn9dR4R39WdePSZiodnteR/8w8Dp0OVc6ZCYt9R14z9bMdOZL6i2fN9nv1nzsP2ASCIJ+1uE81+L3JNYl8pmEotbptU67p5aVMqlr18bqV8vryC38g45sm/Tpe2tD26pMazj2fTB8omn64Zu0L+ici4NhDYf9AwRN1uyPCr4mxOj8PkDwG6u6BYAbN0NnC99IWXqaG8Uhmceb31tP2i82rdbiwyBn8t2XQ5b6IsdfQ4kBG/5CSiJravYHPP70+sE2h7Hx3/shWiMxdc+zh9W9NtDQM74km52vo5blFX5WbDx7+KVrUHqzHD3IPuo1C1wivth/xW47UsPzL6y8syrTm411Kh2s9Vr+hadfwbO04rcaD59fN5D+a/7t7Vqnx5Sc2c+ZMRXyE4Pgqryzhrd1Pfw+OoxQaoQz45AcRX18tnWH4LWDthMGNgitExNTpwmfHzP1MIq550No1sKcnwLf00vTz8um0alrLAP4zhAJum/ywpNCn2Gaci5b95jQyocAPmDddt778GXCP/zVo9cfGcX1BImeemo+vVmep5urm+DJAm9EoNz95JELuM4UYQrXnXSaXGPR8Z7UzzsdPfdlzJi2bDGsvmGEPqhiWRTyPGAjZctOrLRUQ10c5hXzRkxqNn4XLLgAvuzE4wH85U5reaawuFgBBa7cCYrY/fEznHQocuyflQD4oWD1lBtULlOsxFpzn7SAUBsD8tyYRqaQPnsj9o2D8g30LdJBZYnqMtUjMEPm5e1vCICDvMwG0zOU86FnvjR2YNHxtU8YbnZEwJWcCYQKa9vpr1Sj8Miuq1NNVSBUaUt+1L+ofKpLzmTtTC0UW693l07zwjYHhyEXtTA2MhkxDgEOvrLMrib1X1VRNhkHaSMMDH7S2OQayfOuldySmmtui/Mnxeou28UMlc7L4ziQKQZfkLYyU3KDCCe7w1/LB4mqE1+ngjHbE+3cJhJAsMETBVuu5WnUtfIFV0pbd2vQbhAcFlkrX6qWgjFbod3gblFePQVPjm5w5SmhbCxFvYJTf/rUJyo+4xPW6Ner0a0+CRr2n0Rh+MkB7fomCD03r8w9ikKx4CsXpH1HB38B346Aho/EhGLx+yaSc/lzI823DlwZYMxWaB/4v9tI7gVseepWEulgKbKCUy+kBQE2KAocCgQUNIwXUQS+8kE6oDDNK+NFFMGPEiTSDf+28Phj7f7t4HGO+XvwTdyRQYqpGNoAIzmTsqtyXjNhU318EjCLyrsr/4HsFgdclWi3nEm+T4yCYuuq5tRjEc1nRMfmA+/Jmzbt+kSWrioftSMepX7av0PQ1DlDoIDsg9Po2piejgnjrFn1OWuO9GKM+UM66muoR1vKM5b9P/+1NmVbcjzVraiCvTk4SDnmmtBwr7EplE1jjhCrTFjE7nGnEqASCROian7D5tU3/AKOETN9AMlMQBSAE26lG82/8Zg+74itfMjWiYgnOa0TKjZduiqFeAm30c60hWrzE9tqcq+q1YPpChinkwt2W9mFgqrucNmdyvSqtjwXKs1X1QY90zRclTRzOWzjqno12pWm4fI+r+ZwSZlKE6551XoL14S7USoWChcr68Ol1UybntNJslYelcPTlQsqqrTrMISn7qBqCaFM9FZW+3wUDFgtXpPXAx0YVD995kJY6rj5VcIe1CMXo+2xB2mKwocfna4O2zaD8SPgE3pQ9OXQLIbOjHOFt2DJQxfaAlnlx++rwzZy6IJKhB+PrScbY7OUIdnrS5Asj+vp+95bQdwZblIWXRdDwqIMQN42kHNdZZINNxseOqE9DDa2qURXPOs65M1EUQfhoaLB/IcGmmD3RhZkLlmINR09MAsyl/ijJeQxmCO5bKwsVjIpxrikS8VG2ZzyX1wk6zsRKTyZyoRLTrAMRP/Np/fPBrxZTWe6IuSFmWdjzW5NQr9yhhvPXLQ70UDD+CU+KwAXmKNSihyZEZy1ZuOFuLao+uOTdrFiNhTrY/r4M/+snxiyK38C0dhZ22jtFQtkqhEznnpkacci6sMVQJhqSQODX/rW12x+33qgfGeHOckT/J8HlnS94MthKi307L5W10sD2qp8KteFnng2oCEbjZmmMXUb8k7tvpUuW8/xet6O90WgmlBaKvjug/ChsVHsZiToYmAnbcWZ74X1tgZ1od8D768ZWZkDFLFtPOqxlrvu+LF2RB1JbFvO+Qw7yXahNlt4LyRr1xF8lgvmufj0/pn/gFalsJLtInWQwqfyU+ECweMVLOquAJs2O3fdJrpUNdvdZ5PzxhUilKZ8Rl70maDzTI+PS/2cSNnudNl59RHfK7DNt6gvRj1+HM3Q9SyKQKIP9BoT4c2luXJ/PlZ828k+osaXtAQjIGzN6pr1A+g7MK5fPuudGpXKtXh+EVP/ggGaR/R164+aadv1pmJiQagCKQ1q5qgLvFHjazsK1Yj4xktzX2LPC0tQcI+D8nsclMvjoLQfB6V4H2EK696LMnkYFL0JL2F7UJD2oLwcBsViwku/HhRyPSjLhkGRlfCSqQcFUA/KmRFAnPSg1BgGhUNi2+HWsloWgyQoHN508Jncpt5SeDC3Hcs5LvHs5rkLgW2BIzkDPsnQAf1S0RmSoDMkSwf0y5zOkCwd0C93OkNSdEC/AnSGRHSGpOmAfoh0hqTpgH4l6QyJ0xmSoQP6VaKrQvJfKgPlib/njKurZG+u11/A9r/Tk3zAxUYHyHyygdfH8H66BXsLh2L4lJ5F0vrxQ9o7QxbVSTRoZfdUeSsT/y54H0+SPz9/uiRJEisi8Khaj7+697V+nOqNN0becYjFNwJ/XKmKL7u/z28Jn2paJj7bk1sQ+yZchDA1dcV+62E76IxELf9Btla4y/a1cUulc3iqn07Dl41d3R4Ux+GpdHruzkMB/UwPI/62yJkeUkun6lcVtYFZE/BFJVshPE+U9z47uxFdKKJDhCyWR8wB4bq7E2e17Muq7MPT3fRKoxDpZ7XUjSpPDsVtJLGCyPOyJ2ra2pCMWB7IQ45hRogCOfVRdYQl84eMYsoIq/O2Hs9vPifHo55kInmEseEafhFGC1OEtt/zv5yOCjhhGckfXrAYhMAoHZ8c9y57m0IuMo165Ye+Fxcu8fVxv6lgbgJrhwkCUnENZol4bTmQqVCAXAaJd5HoOixdjMDQnm/WvyhFLDU8YgrbNJQ+Qo2j5IoyP95v13mnuvdltVB2qHpsPaGg20SpX/2GLG+srlqOkXzLl6cECByIO6jDNuviicn6w53oUIqN7pOMqxW5n5mF3ZIGykb3P2tnhO5z+ThRnY8WmFBXvLK9ipSO7BvxqP7PhOVF97jIBL/IFN1LGWHooQU/QLMouYJkDn24dCFFHwAd3lfTdEk+CZJY+UVVRnKUpUomVRQ6N0J2Ys4oTz0UXBxV3nmWwF23fjIguRGQPK0In676J5It3jOJpXvQKtYHrsazu689le69ShJJdPYOkKnfHfASgJyMUguxiTB18/XZSDZ8m0YiIBxHvaaRHkwtazwmu/GcCzaejLGC+Nj9xx+SBPlCF15lStkJZeXKOZZtTkjLh+SWXl2bu3nQrOorEIughvfX/nfbvhvGyeagEzDB+7Kscv1/pEfBwOp+L7grH+TBm8OuiW8itppUK7QaRduo1gijCY/Nt8hmH/hv9LF1UHHbfJvtbOUd437JFsuS5IrI0xAHj1f5lzHBsdHqJ1zxs2plJWOcwR7p4cr6Z8CTiBQUWOfjfsMsoY9sUVrWGOuzYMccCIqHp8nUeqe4uQVyfF7K9PIueZTIF3pVSb9HSyM8pu8fwmBQPMkY6D3YFEQ/8Qg5ntj7irdUYk6PuE6Gj0B5aGb+CcYMII3uPQjnmXDQifVSS6J/GPWlE/VI16LPvYDLMy9cYCRE3RNXCIu5IapAkzVujPxAd5m1kRdxu0OtweHyjkaEFDfwWxfcWCRbWPwI+8G8QKG23nl8/46gUFOc5E8vchPX4fYmWILxzS1M2/fJyY27Ckxxsd4k1Zl5mJyOYvuXftO2LP2fHzDqfX6wrfX9hbNuT57TpfpEjaloU+Mn6TVHzB/deyzwVRSUpXtXDZ7VqmnQtjoen1sAmMD4uQ+zm9+wEwawQ04QfatTSkMY7B31vkX5pcqtqCfV+HR7Ig2gFi709k6yHNICa+WOoT5Gl0M68Nq4IGG9343u4iQSpPStsNGHPd1yT51VcWfqgen2qXQmKrOdLqqy3mk0KzGTJjjdGZFWRKWKaXVMdyvj285/HY4A" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-depth-of-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

