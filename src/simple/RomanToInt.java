package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode-13
 * 罗马数字转数字
 *
 * @author yonghua.li01@hand-china.com
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        Map<String, Integer> map = new HashMap<>(16);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return map.get(s);
        }
        for (int i = 0; i < chars.length; i++) {
            //当前面带I，并且后面接着的不是I时，前后两个一起算特殊规则
            if (i + 1 != chars.length && map.keySet().contains("" + chars[i] + chars[i + 1])) {
                sum += map.get("" + chars[i] + chars[i + 1]);
                i++;
            } else {
                sum += map.get(chars[i] + "");
            }
        }
        return sum;
    }


}
