package com.atguigu.springcloud.concurrent.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by dell on 2020/4/16.
 */

@Configuration
@ComponentScan("com.atguigu.springcloud.concurrent.demo")
@EnableAsync
public class SpringConfigDemo {

}
