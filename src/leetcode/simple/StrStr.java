package leetcode.simple;

/**
 * leetcode-28 实现strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 如果neddle为"" 则返回 0。
 *
 * @author yonghua.li01@hand-china.com 2019/10/14 8:53
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
        String haystack1 = "aaaaa";
        String needle1 = "bba";
        System.out.println(strStr(haystack1, needle1));
        String haystack2 = "aaa";
        String needle2 = "aa";
        System.out.println(strStr(haystack2, needle2));
        String haystack3 = "mississippi";
        String needle3 = "issip";
        System.out.println(strStr(haystack3, needle3));
        String haystack4 = "mississippi";
        String needle4 = "pi";
        System.out.println(strStr(haystack4, needle4));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        //记录needle在haystack出现的第一个位置
        int index = -1;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char ci = haystack.charAt(i);
            char cj = needle.charAt(j);
            if (ci == cj) {
                if (index == -1) {
                    index = i;
                }
                if (j == needle.length() - 1) {
                    return index;
                }
                j++;
            } else if (j != 0 && ci != cj) {
                i = index;
                index = -1;
                j = 0;
            }
        }
        return -1;
    }

}
