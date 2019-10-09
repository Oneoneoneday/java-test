package test;

/**
 * description
 *
 * @author yonghua.li01@hand-china.com 2019/09/25 17:12
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 128;
        Integer i3 = 128;
        Integer i4 = 127;
        System.out.println(128 == i2);
        System.out.println(i1.equals(127));
        System.out.println(i2.equals(128));
        //true
        System.out.println(i2 == i3);
        //false
        System.out.println(i1 == i4);
    }

}
