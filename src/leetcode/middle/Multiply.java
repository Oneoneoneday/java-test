package leetcode.middle;

/**
 * @author liyh
 * @version 1.0.0
 * @title
 * @description leetcode-43.字符串相乘
 * @date 2020/8/13 14:39
 */
public class Multiply {

    private static final String ZERO = "0";
    private static final String ONE = "1";

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 示例
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 说明
     * 1.num1 和 num2 的长度小于110。
     * 2.num1 和 num2 只包含数字 0-9。
     * 3.num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */

    public static void main(String[] args) {
        //test("1234", "56789");
        //test("123", "456");
        test("3", "514");
    }

    public static void test(String num1, String num2) {
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (ZERO.equals(num1) || ZERO.equals(num2)) {
            return ZERO;
        }
        // num1 作为被乘数 num2作为乘数
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        String result = ZERO;
        for (int i = chars1.length - 1; i >= 0; i--) {
            StringBuilder sbMul = new StringBuilder();
            int mul1 = Integer.parseInt(chars1[i] + "");
            // 进位
            int mulAdd = 0;
            for (int j = chars2.length - 1; j >= 0; j--) {
                int mul2 = Integer.parseInt(chars2[j] + "");
                int sum = mul1 * mul2 + mulAdd;
                if (sum >= 10) {
                    sbMul.append(sum % 10);
                    mulAdd = sum / 10;
                    if (j == 0) {
                        sbMul.append(mulAdd);
                    }
                } else {
                    sbMul.append(sum);
                    mulAdd = 0;
                }
            }
            result = add(result, format0(sbMul.reverse().toString(), sbMul.length() + chars1.length - 1 - i, false));
        }
        return result;
    }

    /**
     * 两个超长数字字符串相加
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return
     */
    public static String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int length = num1.length();
        // 进位标志
        boolean addFlag = false;
        // 先将两个数字字符串位数补齐
        if (num1.length() != num2.length()) {
            length = Math.max(num1.length(), num2.length());
            num1 = format0(num1, length, true);
            num2 = format0(num2, length, true);
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = length - 1; i >= 0; i--) {
            int add1 = Integer.parseInt(chars1[i] + "");
            int add2 = Integer.parseInt(chars2[i] + "");
            int sum = add1 + add2;
            if (addFlag) {
                sum += 1;
                addFlag = false;
            }
            if (sum >= 10) {
                sb.append(sum % 10);
                addFlag = true;
                if (addFlag && i == 0) {
                    sb.append(ONE);
                }
            } else {
                sb.append(sum);
            }
        }
        return sb.reverse().toString();
    }

    public static String format0(String num, int length, boolean left) {
        length = length - num.length();
        for (int i = 0; i < length; i++) {
            num = left ? ZERO + num : num + ZERO;
        }
        return num;
    }

}
