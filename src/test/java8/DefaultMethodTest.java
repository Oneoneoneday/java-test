package test.java8;

/**
 * java8-接口中的默认方法
 *
 * @author yonghua.li01@hand-china.com 2019/10/10 14:31
 */
public class DefaultMethodTest {

    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
    }

}

interface Vehicle {

    default void print() {
        System.out.println("我是一辆车!");
    }

    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }

}

interface FourWheeler {
    default void print() {
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle, FourWheeler {

    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }

}
