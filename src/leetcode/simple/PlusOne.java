package leetcode.simple;

import java.util.Arrays;

/**
 * leetcode-66 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author yonghua.li01@hand-china.com 2019/10/28 19:52
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        int[] digits1 = {4, 3, 2, 9};
        int[] digits2 = {9};
        int[] digits3 = {9, 9, 9};
        int[] digits4 = {1, 9};
        int[] digits5 = {1, 2, 9};
        int[] digits6 = {0};
        int[] digits7 = {1};
        Arrays.stream(plusOne(digits7)).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int lastDigit = digits[digits.length - 1];
        if (lastDigit != 9) {
            digits[digits.length - 1] = lastDigit + 1;
        } else {
            int lastIndex = digits.length - 1;
            while (lastIndex >= 0) {
                //9 99 999 类似的情况
                if (--lastIndex < 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                    return digits;
                }
                //19  229 类似的情况
                if (digits[lastIndex] != 9) {
                    digits[lastIndex] = digits[lastIndex] + 1;
                    for (int i = digits.length - 1; i > lastIndex; i--) {
                        digits[i] = 0;
                    }
                    return digits;
                }
            }
        }
        return digits;
    }

    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

}
