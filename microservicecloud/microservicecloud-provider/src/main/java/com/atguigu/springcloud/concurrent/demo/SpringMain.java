package com.atguigu.springcloud.concurrent.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dell on 2020/4/16.
 */
public class SpringMain {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigDemo.class);
        SpringDemoService springDemoService = ac.getBean(SpringDemoService.class);
        springDemoService.a();
        springDemoService.b();

    }
}
