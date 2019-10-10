package simple;

/**
 * leetcode-7 整数反转
 * 整数反转
 *
 * @author yonghua.li01@hand-china.com
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(120));
        System.out.println(reverse2(123));
        System.out.println(reverse2(1534236469));
    }

    public static int reverse(int x) {
        //正负标志
        boolean absFlag = false;
        //判断x的正负
        if (x < 0) {
            x = Math.abs(x);
            absFlag = true;
        }
        String str = new StringBuilder(x + "").reverse().toString();
        try {
            x = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
        if (absFlag) {
            return Integer.parseInt("-" + x);
        }
        return x;
    }

    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            /*if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;*/
            //因为int类型最大数和最小数开头的数字只能是1或2，所以如果有最后一次循环的话，pop的值一定为1或2
            //所以(rev == Integer.MAX_VALUE / 10 && pop > 7) (rev == Integer.MIN_VALUE / 10 && pop < -8) 多余
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
