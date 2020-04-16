package com.atguigu.springcloud.concurrent.demo;

public class InterruptDemo extends Thread {
    @Override
    public void run() {
        while (!interrupted())
        {
            System.out.println(getName() + "在运行...");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo demo1 = new InterruptDemo();
        InterruptDemo demo2 = new InterruptDemo();

        Thread.sleep(1000);
        demo1.start();
        demo2.start();

        demo1.interrupt();

    }
}
