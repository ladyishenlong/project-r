package com.ladyishenlong.rprojectjava.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author ruanchenhao
 * @Date 2019-05-28 09:10
 * java 三种线程的创建方式
 */
@Slf4j
public class ThreadJava {


    /**
     * 继承 thread 类创建线程
     * run 线程执行体
     * 调用该类的start()方法，启动线程
     */
    class ThreadEx extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                log.info("线程运行中：{}", i);
            }
        }
    }

    /**
     * 实现 Runnable 接口线程
     * run 线程执行体
     * <p>
     * 创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，
     * 这个Thread对象才是真正的线程对象
     * <p>
     * 第三部依然是通过调用线程对象的start()方法来启动线程
     */
    class ThreadImp implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                log.info("线程运行中：{}", i);
            }
        }
    }

    /**
     * 使用 Callable 和 Future 创建线程
     */
    FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return 5;
        }
    });


    /**
     * 实现Runnable和实现Callable接口的方式基本相同，不过是后者执行call()方法有返回值，后者线程执行体run()方法无返回值，因此可以把这两种方式归为一种这种方式与继承Thread类的方法之间的差别如下：
     * <p>
     * 1、线程只是实现Runnable或实现Callable接口，还可以继承其他类。
     * <p>
     * 2、这种方式下，多个线程可以共享一个target对象，非常适合多线程处理同一份资源的情形。
     * <p>
     * 3、但是编程稍微复杂，如果需要访问当前线程，必须调用Thread.currentThread()方法。
     * <p>
     * 4、继承Thread类的线程类不能再继承其他父类（Java单继承决定）。
     * <p>
     * 注：一般推荐采用实现接口的方式来创建多线程
     */
    public void runThread() {
        ThreadEx threadEx = new ThreadEx();
        threadEx.start();

        ThreadImp threadImp = new ThreadImp();
        Thread thread2 = new Thread(threadImp);
        thread2.start();

        Thread thread3 = new Thread(futureTask);
        thread3.start();
        try {
            futureTask.get();//该方法会阻塞，到线程结束才能拿到
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
