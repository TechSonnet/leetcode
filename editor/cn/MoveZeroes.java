  //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2484, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;
  public class MoveZeroes{
      public static void main(String[] args) {
           Solution solution = new MoveZeroes().new Solution();

           int[] nums = {0,1,0,3,12};
           solution.moveZeroes(nums);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {

        // 1. 定义两个指针，slow 和 fast，二者均指向头结点。
        int slow = 0, fast = 0;

        // 2. fast 指针先移动，负责扫描整个数组中的非零元素。当扫描到非零元素后，将其赋值给 slow 所指向的元素，同时 slow 指针向后移动一步。
        for(fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
        }

        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }