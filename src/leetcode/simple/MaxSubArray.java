package leetcode.simple;

/**
 * leetcode-53 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author yonghua.li01@hand-china.com 2019/10/28 15:40
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {1};
        int[] nums2 = {-2, 1};
//        System.out.println(maxSubArray(nums));
//        System.out.println(maxSubArray(nums1));
//        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray1(nums));
    }

    /**
     *  暴力法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sumMax = 0;
        if (nums.length > 0){
            sumMax = nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sumMax < sum) {
                sumMax = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sumMax < sum) {
                    sumMax = sum;
                }
            }
        }
        return sumMax;
    }

    /**
     *  从前向后当前的保存数列开始，只要总值小于0那么就舍弃，
     *  因为那一部分值无论存在于哪一个子序列中，都是会让总和变小的。
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


}
