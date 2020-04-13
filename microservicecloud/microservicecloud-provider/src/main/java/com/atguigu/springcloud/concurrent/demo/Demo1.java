package com.atguigu.springcloud.concurrent.demo;

public class Demo1 extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(getName() + "在运行...");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();
        demo1.setDaemon(true);
        demo2.setDaemon(true);

        demo1.start();
        demo2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
