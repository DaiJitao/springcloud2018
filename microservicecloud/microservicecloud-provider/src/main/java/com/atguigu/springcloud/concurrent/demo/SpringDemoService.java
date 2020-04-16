package com.atguigu.springcloud.concurrent.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.swing.table.TableRowSorter;

/**
 * Created by dell on 2020/4/16.
 */
@Service
public class SpringDemoService {

    @Async
    public void a() throws InterruptedException {
       while (true){
           Thread.sleep(20000);
           System.out.println("a...");
       }
    }

    @Async
    public void b() throws InterruptedException {
        while (true){
            Thread.sleep(20000);
            System.out.println("b...");
        }
    }
}
