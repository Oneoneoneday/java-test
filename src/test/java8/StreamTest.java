package test.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * java8-流
 *
 * @author yonghua.li01@hand-china.com 2019/10/10 15:28
 */
public class StreamTest {

    public static void main(String[] args) {
        myStreamTest();
    }

    public static void myStreamTest() {
        //生成流
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
        //forEach  limit
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        //sorted
        Random random1 = new Random();
        random1.ints().limit(10).sorted().forEach(System.out::println);
        //filter 获取空字符串的数量
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings1.stream().filter(string -> string.isEmpty()).count();
        System.out.println("stream 获取空字符串的数量:" + count);
        //并行（parallel）程序  获取空字符串的数量
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count1 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("parallelStream 获取空字符串的数量:" + count1);

        //统计
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}
