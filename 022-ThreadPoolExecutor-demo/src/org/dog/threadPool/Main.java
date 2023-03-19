package org.dog.threadPool;

import java.util.concurrent.*;

/**
 * @Author: Odin
 * @Date: 2023/3/19 13:53
 * @Description:
 */
public class Main {

    public static void main(String[] args)  {
        /**
         * 核心线程池数量
         */
        int corePoolSize = 5;
        /**
         * 最大线程池数量 非核心线程池 = 最大线程池 - 核心线程池数量
         */
        int maximunPoolSize = 10;
        /**
         * 非核心线程池最大的空闲时间
         */
        long keepAliveTime = 1;
        /**
         * 非核心线程池最大的空闲时间的单位
         */
        TimeUnit unit = TimeUnit.MINUTES;
        /**
         * 阻塞队列
         */
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        /**
         * 线程池工厂
         */
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        /**
         * 异常处理策略
         */
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        /* 手动构造线程池 */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximunPoolSize, keepAliveTime, unit, workQueue);
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在执行任务A:"+finalI);
                }
            });
        }
    }

}
