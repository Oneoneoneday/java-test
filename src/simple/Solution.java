package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-1 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author yonghua.li01@hand-china.com 2019/10/09 19:59
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] answers = twoSum(nums, target);
        for(int ans : answers){
            System.out.println(ans);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answers = new int[2];
        if (nums.length < answers.length) {
            return answers;
        }
        //1.将nums转为list  外层循环为遍历nums 使用list的contains方法判断
        //2.两层循环
        for(int i = 0; i < nums.length-1; i++){
            int temp = target - nums[i];
            for (int j = i+1; j < nums.length; j++){
                if(temp == nums[j]){
                    answers[0] = i;
                    answers[1] = j;
                    return answers;
                }
            }
        }
        return answers;
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
