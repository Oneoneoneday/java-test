package test.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * 将一段英文拆分，并把每个单词出现的频率按从大到小的顺序打印出来
 *
 * 例如：To be sitting and doing nothing, you must be sitting very, very high up.
 * 输出：[be=2,sitting=2,very=2,and=1,doing=1,nothing=1,you=1,must=1,To=1]
 *
 * @author liyh2333@163.com
 * @package test.java8
 * @date 2020/4/17 10:59
 */
public class Test2 {

    public static void main(String[] args) {
        String str = "To be sitting and doing nothing, you must be sitting very, very high up.";
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c != ',' && c != '.'){
                sb.append(c);
            }
        }
        String[] strArr = sb.toString().split(" ");
        // 使用map存储单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for(String s : strArr){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Integer> values = new ArrayList<>(map.values());
        //从大到小
        Collections.sort(values, Collections.reverseOrder());
        //存储排序后的map
        Map<String, Integer> map2 = new HashMap<>();
        for(Integer i : values){
            for(Map.Entry<String, Integer> entry : entries){
                if(i.equals(entry.getValue()) && !map2.containsKey(entry.getKey())){
                    map2.put(entry.getKey(), entry.getValue());
                    System.out.print(entry.getKey() + "=" + entry.getValue() + ",");
                    break;
                }
            }
        }
    }


}
