package leetcode.simple;

import java.util.*;

/**
 * leetcode-20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 *
 * @author yonghua.li01@hand-china.com 2019/09/06 16:27
 */
public class IsValid {

    public static void main(String[] args) {
        //System.out.println("(())".indexOf(')'));
//        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        stack.push(s.charAt(0));
        //栈原理
        for (int i = 1; i < s.length(); i++) {
            //如果栈顶是右括号，则始终匹配不上括号
            if (!stack.isEmpty() && !map.containsKey(stack.peek())) {
                return false;
            }
            //取栈顶对应的有括号与当前要推入的对比，如果能匹配上括号则推出栈顶
            boolean flag = !stack.isEmpty() && map.get(stack.peek()) == s.charAt(i);
            if (flag) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }


}
