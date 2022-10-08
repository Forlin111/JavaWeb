package threadLocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class threadLocalTest {
   // public static Map<String,Object> map=new Hashtable<>();
    private static Random random=new Random();
    public static ThreadLocal<Object> threadLocal=new ThreadLocal<>();
    //这里演示线程跟数据绑定,不管这个线程执行多少动作,只要在这个线程里就可以去除对应的数据,跟map的差不多;

    public static class task implements Runnable{
        @Override
        public void run() {
            Integer i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程"+name+"随机生产的数为"+i);
            //map.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Object o = map.get(name);
            Object o = threadLocal.get();
            System.out.println(name+":::"+o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new task()).start();
        }
    }
}
