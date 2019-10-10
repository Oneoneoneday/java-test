package leetcode.simple;

import java.util.Arrays;

/**
 * leetcode-14 最长公共前缀
 * 取最长公共前缀，字符串数组中的字符串为a-z
 *
 * @author yonghua.li01@hand-china.com 2019/09/04 15:40
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix2(strs1));
        System.out.println(longestCommonPrefix2(strs2));
        System.out.println(longestCommonPrefix2(new String[]{}));
        System.out.println(longestCommonPrefix2(new String[]{""}));
        System.out.println(longestCommonPrefix3(strs1));
        System.out.println(longestCommonPrefix3(strs2));
        System.out.println(longestCommonPrefix3(new String[]{}));
        System.out.println(longestCommonPrefix3(new String[]{""}));
    }

    public static String longestCommonPrefix(String[] strs) {
        //原理：一个字母一个字母比较，再加入到一个前缀字符串中
        //判断strs是否是空字符串数组，判断字符串数组中是否含有""
        if (strs.length == 0 || Arrays.asList(strs).contains("")) {
            return "";
        }
        boolean flag = true;
        int index = 0;
        //记录这组字符串中最小的长度
        int minLength = strs[0].length();
        StringBuffer prefix = new StringBuffer(strs[0].charAt(index) + "");
        //通过第一个字母判断是否不含有公共字符串
        for (int i = 0; i < strs.length; i++) {
            if (!prefix.toString().equals(strs[i].charAt(index) + "")) {
                return "";
            }
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        while (flag) {
            //一直取前缀，并与每一个字符串比较
            if (prefix.length() == minLength) {
                return prefix.toString();
            }
            prefix.append(strs[0].charAt(++index));
            for (int i = 0; i < strs.length; i++) {
                //substring  0,2 取的是从0开始，两位
                if (!prefix.toString().equals(strs[i].substring(0, prefix.length()))) {
                    prefix.deleteCharAt(prefix.length() - 1);
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        //两层for循环
        //判断是否是空字符串数组
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        //外层是字符串数组的数量
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            //内层是既小于第一个字符串的长度，也小于后面遍历的字符串的长度
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

    public static String longestCommonPrefix3(String[] strs) {
        //原理，两层for循环，先取出第一个字符串，再使用chatAt判断后面每一个字符串中的每一个字母
        if (strs.length == 0 || Arrays.asList(strs).contains("")) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

}
