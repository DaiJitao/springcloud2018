package com.atguigu.springcloud.concurrent.demo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dell on 2020/4/16.
 */
public class DemoTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test...");
            }
        };

        timer.schedule(task,0, 10000 );

    }


}
