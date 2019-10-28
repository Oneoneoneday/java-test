package leetcode.simple;

import com.sun.deploy.util.StringUtils;

/**
 * leetcode-58 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串
 *
 * @author yonghua.li01@hand-china.com 2019/10/28 19:24
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
        String s1 = "HellO";
        System.out.println(lengthOfLastWord(s1));
        String s2 = "a  ";
        System.out.println(lengthOfLastWord(s2));
        String s3 = "  ";
        System.out.println(lengthOfLastWord(s3));
        System.out.println(" ".trim().split(" ").length);
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }

}
