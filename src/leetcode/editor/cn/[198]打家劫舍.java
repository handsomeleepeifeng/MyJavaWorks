//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 
// 👍 1568 👎 0

package leetcode.editor.cn;

class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        System.out.printf(String.valueOf(solution.rob(new int[]{1, 100, 1, 1, 100})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这里关系是要么是往前2个房间，或者往前3个房间，如果往前4个房间，那么必然可以在这中间偷第2个房间，所以只能是2或者3
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            int[] arr = new int[nums.length];
            arr[0] = nums[0];
            if (nums.length == 1) {
                return arr[0];
            }
            arr[1] = nums[0] > nums[1] ? nums[0] : nums[1];
            if (nums.length == 2) {
                return arr[1];
            }
            arr[2] = arr[0] + nums[2] > arr[1] ? arr[0] + nums[2] : arr[1];
            if (nums.length == 3) {
                return arr[2];
            }
            for (int i = 3; i < nums.length; i++) {
                int temp = arr[i - 3] + nums[i] > arr[i - 2] + nums[i] ? arr[i - 3] + nums[i] : arr[i - 2] + nums[i];
                arr[i] = arr[i - 1] > temp ? arr[i - 1] : temp;
            }
            return arr[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
