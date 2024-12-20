<p>给定一个已排序的链表的头
 <meta charset="UTF-8" />&nbsp;<code>head</code>&nbsp;，&nbsp;<em>删除所有重复的元素，使每个元素只出现一次</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="height: 160px; width: 200px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2]
<strong>输出：</strong>[1,2]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="height: 123px; width: 300px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2,3,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>题目数据保证链表已经按升序 <strong>排列</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1164, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/array-two-pointers-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.online/algo/images/array-dedup/2.gif)

**详细题解**：
  - [双指针技巧秒杀七道数组题目](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/)

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
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {  // 删除链表中重复的元素
        if (head == NULL) return NULL;  // 如果链表为空，直接返回NULL
        ListNode *slow = head, *fast = head;  // 定义快慢指针，初始都指向头结点
        while (fast != NULL) {  // 只要快指针没有遍历完整个链表
            if (fast->val != slow->val) {  // 快慢指针值不同
                slow->next = fast;  // 慢指针连接新节点
                slow = slow->next;  // 慢指针向后移动一位
            }
            fast = fast->next;  // 快指针向后移动一位
        }
        slow->next = NULL;  // 断开与后面重复元素的连接
        return head;  // 返回头结点
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        slow = head
        fast = head
        while fast != None:
            if fast.val != slow.val:
                # nums[slow] = nums[fast];
                slow.next = fast
                # slow++;
                slow = slow.next
            # fast++
            fast = fast.next
        # 断开与后面重复元素的连接
        slow.next = None
        return head
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    slow, fast := head, head
    for fast != nil {
        if fast.Val != slow.Val {
            // nums[slow] = nums[fast];
            slow.Next = fast
            // slow++;
            slow = slow.Next
        }
        // fast++
        fast = fast.Next
    }
    // 断开与后面重复元素的连接
    slow.Next = nil
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码暂未通过力扣的验证，如有错误，请参照我写的 java 代码对比查看。我正在手动验证这部分代码...

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null) return null;
  var slow = head;
  var fast = head;
  while (fast !== null) {
    if (fast.val !== slow.val) {
      // nums[slow] = nums[fast];
      slow.next = fast;
      // slow++;
      slow = slow.next;
    }
    // fast++
    fast = fast.next;
  }
  // 断开与后面重复元素的连接
  slow.next = null;
  return head;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

</div>
</details>
</div>

