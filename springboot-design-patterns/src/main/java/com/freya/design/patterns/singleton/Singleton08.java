package com.freya.design.patterns.singleton;

/**
 * 枚举单例,JAVA 大神推荐
 * 不仅可以解决线程同步，还可以防止反序列化,语义上不太符合业务，酌情使用
 */
public enum Singleton08 {

    INSTANCE;

    /**
     * 业务代码
     */
    public void business() {
        System.out.println("TODO");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Singleton08.INSTANCE.hashCode());
            }).start();
        }
    }
}


