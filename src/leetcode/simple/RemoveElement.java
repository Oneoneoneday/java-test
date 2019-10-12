package leetcode.simple;

import java.util.Arrays;

/**
 * leetcode-27 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 例如：
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * @author yonghua.li01@hand-china.com 2019/10/12 13:45
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] nums1 = {2};
        int val1 = 2;
        int[] nums2 = {4,5};
        int val2 = 4;
        int len = removeElement1(nums, val);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                continue;
            }
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] != val){
                    nums[i] = nums[j];
                    nums[j] = val;
                    break;
                }
            }
            //val 不再和后面的数交换时，记录len
            if(len == nums.length && nums[i] == val){
                len = i;
                break;
            }
        }
        return len;
    }

    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
