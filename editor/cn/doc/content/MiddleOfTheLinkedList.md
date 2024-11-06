<p>给你单链表的头结点 <code>head</code> ，请你找出并返回链表的中间结点。</p>

<p>如果有两个中间结点，则返回第二个中间结点。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[3,4,5]
<strong>解释：</strong>链表只有一个中间结点，值为 3 。
</pre>

<p><strong class="example">示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5,6]
<strong>输出：</strong>[4,5,6]
<strong>解释：</strong>该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表的结点数范围是 <code>[1, 100]</code></li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 1025, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：

我们让两个指针 `slow` 和 `fast` 分别指向链表头结点 `head`。

**每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步，这样，当 `fast` 走到链表末尾时，`slow` 就指向了链表中点**。

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
    ListNode* middleNode(ListNode* head) {
        // 快慢指针初始化指向 head
        ListNode* slow = head;
        ListNode* fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
        }
        // 慢指针指向中点
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
    # 快慢指针初始化指向 head
    def middleNode(self, head: ListNode) -> ListNode:
        slow = head
        fast = head
        # 快指针走到末尾时停止
        while fast is not None and fast.next is not None:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
        # 慢指针指向中点
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func middleNode(head *ListNode) *ListNode {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
    }
    // 慢指针指向中点
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var middleNode = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
    }
    // 慢指针指向中点
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_middle-of-the-linked-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_middle-of-the-linked-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>



