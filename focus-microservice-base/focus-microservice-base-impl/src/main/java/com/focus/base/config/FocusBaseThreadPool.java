package com.focus.base.config;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FocusBaseThreadPool {

    //单例模式，私有构造方法，防止外界创造实例
    private FocusBaseThreadPool() {
    }

/*
    *//**
     * 饿汉模式，将创造对象放在类加载的过程中，简单、线程安全，但要提前占用系统资源
     *//*
    private static ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ExecutorService getTreadPool(){
        return threadPool;
    }*/

    /**
     * 懒汉模式，用户第一次使用时才创建，但需要手动实现线程安全,否则线程不安全有可能创建多个实例
     */
    private static ExecutorService threadPool = null;

    private static Byte[] lock = new Byte[1];

    public static ExecutorService getTreadPool(){

        //双重锁定：保证线程安全，同时不必让线程每次都加锁
      if (threadPool == null){
            synchronized (lock){
                //同步锁中必须再判断一次是否为null，否则两个线程同时判断实例未创建后，一个线程创建后，保证另一个线程不会再创建
                if (threadPool == null)
                    threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            }
        }
        return threadPool;
    }

    public static void execute(Runnable runnable){
        getTreadPool().execute(runnable);
    }

    public static<T> Future<T> submit(Callable<T> callable){
        return getTreadPool().submit(callable);
    }
}
