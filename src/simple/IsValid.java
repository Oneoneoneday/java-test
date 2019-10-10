package simple;

/**
 * leetcode-20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author yonghua.li01@hand-china.com 2019/09/06 16:27
 */
public class IsValid {

    public static void main(String[] args) {
        //System.out.println("(())".indexOf(')'));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        //判断空字符串和字符串长度不为偶数，或者为偶数但是左右括号数量不匹配
        if ("".equals(s)) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        }
        //记录左右括号出现的数量
        //小括号( ) 中括号[] 大括号{}
        int left1 = 0, right1 = 0, left2 = 0, right2 = 0, left3 = 0, right3 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left1++;
            } else if (s.charAt(i) == ')') {
                right1++;
            } else if (s.charAt(i) == '[') {
                left2++;
            } else if (s.charAt(i) == ']') {
                right2++;
            } else if (s.charAt(i) == '{') {
                left3++;
            } else if (s.charAt(i) == '}') {
                right3++;
            }
        }
        if (left1 != right1 || left2 != right2 || left3 != right3) {
            return false;
        }
        //判断左右括号是否匹配

        return true;
    }


}
