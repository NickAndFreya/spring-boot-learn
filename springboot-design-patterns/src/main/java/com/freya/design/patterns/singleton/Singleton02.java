package com.freya.design.patterns.singleton;

/**
 * 同方式一
 */

public class Singleton02 {
    private static final Singleton02 INSTANCE;
    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02 () {};

    public static Singleton02  getInstance() {
        return INSTANCE;
    }

    /**
     * 业务代码
     */
    public void business() {
        System.out.println("TODO");
    }

    public static void main(String[] args) {
        Singleton02 s1 = Singleton02 .getInstance();
        Singleton02 s2 = Singleton02 .getInstance();
        System.out.println(s1 == s2);
    }
}

