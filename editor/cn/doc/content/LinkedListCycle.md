<p>给你一个链表的头节点 <code>head</code> ，判断链表中是否有环。</p>

<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。<strong>注意：<code>pos</code> 不作为参数进行传递&nbsp;</strong>。仅仅是为了标识链表的实际情况。</p>

<p><em>如果链表中存在环</em>&nbsp;，则返回 <code>true</code> 。 否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>false
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围是 <code>[0, 10<sup>4</sup>]</code></li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 为 <code>-1</code> 或者链表中的一个 <strong>有效索引</strong> 。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能用 <code>O(1)</code>（即，常量）内存解决此问题吗？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 2220, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

经典题目了，要使用双指针技巧中的快慢指针，每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步。

如果 `fast` 最终遇到空指针，说明链表中没有环；如果 `fast` 最终和 `slow` 相遇，那肯定是 `fast` 超过了 `slow` 一圈，说明链表中含有环。

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
    bool hasCycle(ListNode *head) {
        // 快慢指针初始化指向 head
        ListNode *slow = head, *fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
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
    def hasCycle(self, head: ListNode) -> bool:
        slow = head
        fast = head
        # 快指针走到末尾时停止
        while fast is not None and fast.next is not None:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
            # 快慢指针相遇，说明含有环
            if slow == fast:
                return True
        # 不包含环
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func hasCycle(head *ListNode) bool {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
        // 快慢指针相遇，说明含有环
        if slow == fast {
            return true
        }
    }
    // 不包含环
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var hasCycle = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
        // 快慢指针相遇，说明含有环
        if (slow === fast) {
            return true;
        }
    }
    // 不包含环
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_linked-list-cycle" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle"></div></div>
</details><hr /><br />

</div>
</details>
</div>

