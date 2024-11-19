  //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 1648, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package cn;
  public class BinarySearch{
      public static void main(String[] args) {
           Solution solution = new BinarySearch().new Solution();

           int[] nums = {-1,0,3,5,9,12};
           int target = 2;

          int searchRes = solution.search(nums, target);
          System.out.println(searchRes);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

        // 1. 定义两个指针，left 和 right，用来界定搜索边界。
        int left = 0, right = nums.length - 1;

        // 2. 当左右指针未重合时，寻找中间元素，看是否为所需要的元素。是则返回下标，不是则改变搜索边界。
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }

        return -1;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }