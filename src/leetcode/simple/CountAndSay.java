package leetcode.simple;

/**
 * leetcode-38 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * @author yonghua.li01@hand-china.com 2019/10/23 14:56
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String say = "1";
        for (int i = 0; i < n - 1; i++) {
            String tempSay = "";
            int count = 0;
            char c = say.charAt(0);
            // 数数时相同字段没有了、或者数到底了要停止
            for (int j = 0; j < say.length(); j++) {
                if (c == say.charAt(j)) {
                    count++;
                }
                if (j == say.length() - 1 || c != say.charAt(j+1)){
                    tempSay += "" + count + c;
                    if(j == say.length() - 1 ) {
                        c = say.charAt(j);
                    } else {
                        c = say.charAt(j+1);
                    }
                    count = 0;
                }
            }
            say = tempSay;
        }
        return say;
    }

}
