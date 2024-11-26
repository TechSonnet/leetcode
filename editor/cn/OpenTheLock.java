  //你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
//
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示：
//
//
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// Related Topics广度优先搜索 | 数组 | 哈希表 | 字符串 
//
// 👍 680, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.util.HashSet;
  import java.util.LinkedList;
  import java.util.Queue;
  import java.util.Set;

  public class OpenTheLock{
      public static void main(String[] args) {
           Solution solution = new OpenTheLock().new Solution();
           String[] deadends = {"0201","0101","0102","1212","2002"};
          System.out.println(solution.openLock(deadends, "0202"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        // 1. 实现广度优先搜索的代码框架。
        //   a. 核心数据结构 - 队列，记录遍历的元素。理论上，如果进行一次完整的广度优先搜索，树或者图中所有的元素都会进入这个队列。
        Queue<String> queue = new LinkedList<>();
        //   b. visited 集合/数组，用来记录已经访问的元素。一般来说，树不需要这个 visited，而图由于存在环，会需要这个数组。
        // 这里有一个非常有意思的现象，a,b 这两步定义的数据结构经常一起出现
        Set<String> visited = new HashSet<>();



        int step = 0;  // 记录最小次数
        queue.offer("0000");
        visited.add("0000");
        //   c. while + for 循环，元素会根据队列 的状态，不断地出队和入队。
        while(!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++){
                String cur = queue.poll();
                // 判断是否到达终点，若到达，执行对应操作
                if (deads.contains(cur)){
                    continue; // 终结这颗子树
                }
                if (cur.equals(target)){
                    return step;
                }

                // 这是一个个性化操作，每个不同的情况，相邻元素入队的方式也是不一样的
                for (int j = 0; j < 4; j++) {
                    // 想好相邻元素怎么入队，是很重要的
                    String up  = plusOne(cur, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        // 2. 根据题目限制，deadends 对这个框架做一些改动。
        //   a. 在进行一次选择后，如果出现的字符串包含在 deadends 中，直接终止这颗子树。

        return -1;
    }

    private String plusOne(String cur, int j){
        char[] ch = cur.toCharArray();
        if(ch[j] == '9'){
            ch[j] = '0';
        }else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String cur, int j){
        char[] ch = cur.toCharArray();
        if (ch[j] == '0'){
            ch[j] = '9';
        }else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }