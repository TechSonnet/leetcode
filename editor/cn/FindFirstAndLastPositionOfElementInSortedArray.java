  //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2826, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;
  public class FindFirstAndLastPositionOfElementInSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

           int[] nums = {5,7,7,8,8,10};

          int[] ints = solution.searchRange(nums, 6);
          for (int anInt : ints) {
              System.out.println(anInt);
          }

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {

        // 1. 二分搜索，找到一个 target 的下标
        int left = 0, right = nums.length - 1;
        while (left <= right){

            int  mid = left + (right - left) / 2;

            if(nums[mid] == target){
                // 2. 从这个下标的位置，探索左右边界
                return searchBoundary(nums, mid, target);
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }


        return new int[]{-1, -1};
    }

    private int[] searchBoundary(int[] nums, int index, int target){

        int left = index, right = index;
        // 1. 找左边界
        while (nums[left] == target){
            left--;
        }

        // 2. 找右边界
        while (nums[right] == target){
            right++;
        }

        return new int[]{++left, --right};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }