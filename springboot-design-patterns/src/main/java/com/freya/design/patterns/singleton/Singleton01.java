package com.freya.design.patterns.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：类装载时就完成实例化
 */
public class Singleton01{
    private static final Singleton01 INSTANCE = new Singleton01 ();

    private Singleton01() {};

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    /**
     * 业务代码
     */
    public void business() {
        System.out.println("TODO");
    }

    public static void main(String[] args) {
        Singleton01 s1= Singleton01.getInstance();
        Singleton01 s2= Singleton01.getInstance();
        System.out.println(s1== s2);
    }
}

