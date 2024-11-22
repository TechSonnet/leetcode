  //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2995, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;

  import java.util.LinkedList;
  import java.util.List;

  public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();

           int[] nums = {1,2,3};

           solution.permute(nums);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new LinkedList<>(); // record the result

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>(); // record a path
        boolean[] used = new boolean[nums.length]; // Elements in the path are marked true avoid reuse

        backtrack(nums, track, used);

        // System.out.println(res);

        return res;


    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used){

        //  1. 递归出口，到达 nums 的长度，即找到了一个排列
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        //  2. 循环遍历 nums 数组
        for (int i = 0; i < nums.length; i++){
            //   a. 已经遍历过的元素直接跳过，是为已经走过的路径
            if(used[i] == true) continue;
            //   b. 对于没有遍历过的元素，则移动到该节点，并递归调用，进入新节点
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums,track,used);
            //   c. 因为是回溯算法，最后要撤销走的那一步，需要回去，所以叫做回溯嘛
            track.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }