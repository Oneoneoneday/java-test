package study.myenum;
/**
 *
 * 枚举类
 * 1.默认继承自Enum类
 * 2.构造方法是私有的
 * 3.线程安全
 * 4.类型安全
 * 5.创建实例时只能在枚举类首行分号前创建
 * 6.单例模式和策略模式
 *
 * @package study.myenum
 * @author liyh2333@163.com
 * @date 2020/3/29 14:35
 */
public class Pizza {

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    // Methods that set and get the status variable.

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

//    @Test
//    public void givenPizaOrder_whenReady_thenDeliverable() {
//        Pizza testPz = new Pizza();
//        testPz.setStatus(Pizza.PizzaStatus.READY);
//        assertTrue(testPz.isDeliverable());
//    }

}