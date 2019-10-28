package test.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import test.daily.entitiy.A;

/**
 * description
 *
 * @author yonghua.li01@hand-china.com 2019/10/25 11:55
 */
public class GroupByToMapTest {
    

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new A("code1","name1"));
        list.add(new A("code1","name2"));
        list.add(new A("code2","name2"));
        list.add(new A("code3","name3"));
        Map<String, List<A>> collect = list.stream().collect(Collectors.groupingBy(A::getCode));


    }

}
