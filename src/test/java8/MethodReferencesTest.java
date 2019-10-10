package test.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * java8-方法引用测试
 *
 * @author yonghua.li01@hand-china.com 2019/10/10 10:32
 */
public class MethodReferencesTest {

    public static void main(String[] args) {
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }

}
