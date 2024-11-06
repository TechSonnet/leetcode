<p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], n = 2
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [1], n = 1
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], n = 1
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中结点的数目为 <code>sz</code></li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 2969, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.online/algo/images/linked-list-two-pointer/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.online/algo/images/linked-list-two-pointer/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.online/algo/images/linked-list-two-pointer/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

**详细题解**：
  - [双指针技巧秒杀七道链表题目](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/)

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
    // 主函数
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != nullptr) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    # 主函数
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1:
            p2 = p2.next
            p1 = p1.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

// 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n+1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1 := head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    p2 := head
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p2 = p2.Next
        p1 = p1.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    let dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    let x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
function findFromEnd(head, k) {
    let p1 = head;
    // p1 先走 k 步
    for (let i = 0; i < k; i++) {
        p1 = p1.next;
    }
    let p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 !== null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>

