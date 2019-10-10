package leetcode.simple;

/**
 * leetcode-9 回文数
 * 判断是否是回文数
 *
 * @author yonghua.li01@hand-china.com
 */
public class Palindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(-121));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome2(12321));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome2(-1));
        System.out.println(isPalindrome2(0));
        System.out.println(isPalindrome2(1));
        System.out.println(isPalindrome2(21120));
//        System.out.println(isPalindrome3(101));
//        System.out.println(isPalindrome3(10));
//        System.out.println(isPalindrome3(11));
//        System.out.println(isPalindrome3(12321));
//        System.out.println(isPalindrome3(10));
//        System.out.println(isPalindrome3(-1));
//        System.out.println(isPalindrome3(0));
//        System.out.println(isPalindrome3(1));
//        System.out.println(isPalindrome3(21120));
    }

    public static boolean isPalindrome(int x) {
        char[] arr = (x + "").toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        //从头开始判断并记录前面的和后面的是否相同  偶数位a==b || 奇数位a==b/10
        //是否到中间的标志: x/10 >= rev*10
        int rev = 0;
        //小于0不是回文数 ，能够被10整除的不是回文数
        //0-9为回文数
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        //判断是否到中间  12321      [x:1232 rev:1 x/10>rev*10]      [x:123 rev:12 x/10 < rev*10]
        //1001  [x:100 rev:1]
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
            System.out.println("x:" + x + ",rev:" + rev);
        }
        //偶数的时候和基数的时候
        return x == rev || x == rev / 10;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        //取首位和末位判断法
        //先计算出最高位是几位 如1111为1000
        int help = 1;
        int temp = x;
        while (temp / 10 > 0) {
            help *= 10;
            temp /= 10;
        }
        System.out.println("help:" + help);
        while (help != 0) {
            System.out.println(x);
            //判断首位和末位是否相同
            if (x / help != x % 10) {
                return false;
            }
            //去除首位和末位之后
            x = (x - x % 10 * help) / 10;
            help /= 100;
        }
        return true;
    }

}
