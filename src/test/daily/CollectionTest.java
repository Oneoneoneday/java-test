package test.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * list的remove方法和subList方法测试
 *
 * @author yonghua.li01@hand-china.com 2019/09/25 17:14
 */
public class CollectionTest {

    public static void main(String[] args) {
        removeTest1();
        removeTest2();
    }

    public static void removeTest1(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(list);
        for (String item : list) {
            //1不会报错，2会报错
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }

    /**
     * 正确操作方式
     */
    public static void removeTest2(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void subListTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("subList(0,2)");
        list.subList(0, 2).forEach(System.out :: println);
        list.subList(0, 2).remove(0);
        System.out.println("subList.remove(0)");
        System.out.println("list");
        list.forEach(System.out :: println);
    }

}
