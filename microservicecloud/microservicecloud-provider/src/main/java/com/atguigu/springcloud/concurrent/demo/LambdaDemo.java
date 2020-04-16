package com.atguigu.springcloud.concurrent.demo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2020/4/16.
 */
public class LambdaDemo {

    public int add(List<Integer> list){
        // list.parallelStream().forEach(System.out :: println);
        list.parallelStream().forEachOrdered(System.out::println);

        return 0;
        // return list.parallelStream().mapToInt(a -> a).sum();// 并发刘
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,13,14,15,18,19,20,21,22,23,24,25,26);
        new LambdaDemo().add(list);

    }
}
