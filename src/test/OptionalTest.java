package test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * jdk8新特性，使用Optional避免NPE
 *
 * @author yonghua.li01@hand-china.com 2019/10/09 15:13
 */
public class OptionalTest {

    public static void main(String[] args) {
        //equalsTest();
        //isPresentTest();
        //ifPresentTest();
        //orElseTest();
        //orElseGetTest();
        //orElseThrowTest();
        filterTest();
        //mapTest();
        //flatMapTest();
    }

    private static void createOptional() {
        //参数不能是null
        Optional<Integer> optional1 = Optional.of(1);
        //参数可以是null
        Optional<Object> optional2 = Optional.ofNullable(null);
        //参数可以是非null
        Optional<Integer> optional3 = Optional.ofNullable(2);
    }


    private static void equalsTest() {
        Optional<Object> optional1 = Optional.ofNullable(null);
        Optional<Object> optional2 = Optional.ofNullable(null);
        //true
        System.out.println(optional1 == optional2);
        //true
        System.out.println(optional1.equals(Optional.<Integer>empty()));

        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        //true
        System.out.println(o1 == o2);
    }

    private static void isPresentTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // isPresent判断值是否存在
        System.out.println(optional1.isPresent() == true);
        System.out.println(optional2.isPresent() == false);
    }

    private static void ifPresentTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 如果不是null,调用Consumer
        optional1.ifPresent(t -> System.out.println("value is " + t));

        // null,不调用Consumer
        optional2.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });
    }

    /**
     * orElse 如果原本的optional中有值，使用orElse传入null或是任意值都是原先的值
     */
    private static void orElseTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        System.out.println(optional1.orElse(null));
        System.out.println(optional2.orElse(2));
        // orElse  true
        System.out.println(optional1.orElse(1000) == 1);
        //true
        System.out.println(optional2.orElse(1000) == 1000);
    }

    /**
     * orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
     */
    private static void orElseGetTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        //true
        System.out.println(optional1.orElseGet(() -> 1000) == 1);
        //true
        System.out.println(optional2.orElseGet(() -> {
            return 1000;
        }) == 1000);

    }

    /**
     * orElseThrow()：值不存在则抛出异常，存在则什么不做，有点类似Guava的Precoditions
     */
    private static void orElseThrowTest() throws Throwable{

        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        optional1.orElseThrow(() -> {
            throw new IllegalStateException();
        });

        try {
            // 抛出异常
            optional2.orElseThrow(() -> {
                throw new IllegalStateException();
            });
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    public static void filterTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 判断optional1中是否含有null   optional1中不存在
        Optional<Integer> filter1 = optional1.filter((a) -> a == null);
        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);
        //判断oprional2中是否含有null    optional2存在null 并返回一个新的Optional,值为null
        Optional<Integer> filter3 = optional2.filter((a) -> a == null);
        //false
        System.out.println(filter1.isPresent());
        //true
        System.out.println(filter2.isPresent());
        //true
        System.out.println(filter2.get().intValue() == 1);
        //false
        System.out.println(filter3.isPresent());

    }

    /**
     * map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
     */
    public static void mapTest() {

        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
        Optional<String> str2Optional = optional2.map((a) -> "key" + a);

        // key1
        System.out.println(str1Optional.get());
        // false
        System.out.println(str2Optional.isPresent());
    }

    /**
     * 功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
     * map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
     */
    public static void flatMapTest() {
        Optional<Integer> optional1 = Optional.ofNullable(1);

        Optional<Optional<String>> str1Optional = optional1.map((a) -> Optional.<String>of("key" + a));

        Optional<String> str2Optional = optional1.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });

        // key1
        System.out.println(str1Optional.get().get());
        // key1
        System.out.println(str2Optional.get());

    }

}
