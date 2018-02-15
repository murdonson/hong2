package com.concurrency;

/**
 *  静态内部类实现单例模式
 */
public class SingletonObject
{
    private SingletonObject(){}

    private static class InstanceHolder
    {
        private static final SingletonObject intance=new SingletonObject();
    }

    // 调用这个方法时才会触发 静态内部类的加载 初始化  jvm类加载机制保证这个时候是单线程的 而且做到了懒加载
    public static SingletonObject getInstance()
    {
        return InstanceHolder.intance;
    }
}
