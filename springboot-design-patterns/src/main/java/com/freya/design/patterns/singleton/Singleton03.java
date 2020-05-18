package com.freya.design.patterns.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 多线程下并不能保证单例
 */
public class Singleton03{
    private static Singleton03 INSTANCE;

    private Singleton03 () {
    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
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
            new Thread(()->
                    System.out.println(Singleton03.getInstance().hashCode())
            ).start();
        }
    }
}


