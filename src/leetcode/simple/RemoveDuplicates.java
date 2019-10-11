package leetcode.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode-26
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author yonghua.li01@hand-china.com 2019/10/11 19:08
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        int len = sortedList.size();
        for (int i = 0; i < len; i++) {
            nums[i] = sortedList.get(i);
        }
        return len;
    }

    public static int removeDuplicates1(int[] nums) {
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }

}
