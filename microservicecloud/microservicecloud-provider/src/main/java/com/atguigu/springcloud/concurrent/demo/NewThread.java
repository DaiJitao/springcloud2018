package com.atguigu.springcloud.concurrent.demo;

public class NewThread implements Runnable {
    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.getAllStackTraces() + "子线程在运行...");
        }
    }

    public static void main(String[] args) {
        NewThread n = new NewThread();
        Thread thread = new Thread(n);
        thread.start();
        while (true){
            System.out.println(NewThread.class.getClassLoader() + "主线程在执行");
            synchronized (n){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }
        }
    }
}
