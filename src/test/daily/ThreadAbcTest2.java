package test.daily;

/**
 * @author liyh2333@163.com
 * @package test.daily
 * @date 2020/4/7 11:05
 */
public class ThreadAbcTest2 {

    private static int flag = 0;

    public static void main(String[] args) {
        ThreadAbcTest2 threadAbcTest2 = new ThreadAbcTest2();
        new Thread(()->{
            while(true){
                threadAbcTest2.printA();
            }
        }).start();
        new Thread(()->{
            while(true){
                threadAbcTest2.printB();
            }
        }).start();
        new Thread(()->{
            while(true){
                threadAbcTest2.printC();
            }
        }).start();

    }

    void printA(){
        if(flag == 0){
            System.out.println("A");
            flag = 1;
        }
    }

    void printB(){
        if(flag == 1){
            System.out.println("B");
            flag = 2;
        }
    }

    void printC(){
        if(flag == 2){
            System.out.println("C");
            System.out.println("```````````````");
            flag = 0;
        }
    }

}


