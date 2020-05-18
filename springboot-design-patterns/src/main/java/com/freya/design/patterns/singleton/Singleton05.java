package com.freya.design.patterns.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 减少synchronized代码块以提高效率，但多线程下不能保证单例
 *
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;

    private Singleton05 () {
    }

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05 ();
            }
        }
        return INSTANCE;
    }

    /**
     * 业务代码
     */
    public void business() {
        System.out.println("TODO");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}


