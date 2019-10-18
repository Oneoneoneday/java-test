package leetcode.simple;

/**
 * leetcode-35 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @author yonghua.li01@hand-china.com 2019/10/18 10:17
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        int target1 = 3;
        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert(nums, target1));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i]) {
                index = i + 1;
            }
        }
        return index;
    }

}
