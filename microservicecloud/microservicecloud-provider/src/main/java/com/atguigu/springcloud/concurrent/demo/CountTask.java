package com.atguigu.springcloud.concurrent.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer>{
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);
        Future<Integer> future = pool.submit(countTask);
        try {
            System.out.println(future.get());
            System.out.println(countTask.isCompletedAbnormally());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static final int threadsHold = 2;
    private int start;
    private int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = ((end - start) <= threadsHold);
        if (canCompute){
            for(int i = start; i <= end; i++){
                sum += i;
            }
        }else {
            int midd = (end+start)/2;
            // 分裂成为子任务
            CountTask countTask1 = new CountTask(start, midd);
            CountTask countTask2 = new CountTask(midd+1, end);
            // jisuan
            countTask1.fork();
            countTask1.fork();

            int rs1 = countTask1.join();
            int rs2 = countTask2.join();

            sum = rs1 + rs2;


        }
        return sum;
    }
}
