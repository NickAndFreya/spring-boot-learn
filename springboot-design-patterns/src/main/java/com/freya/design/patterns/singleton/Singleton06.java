package com.freya.design.patterns.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 双重检查保证多线程下单例
 * 推荐使用
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE;

    private Singleton06 () {
    }

    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Singleton06.class) {
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
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
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
    }
}


