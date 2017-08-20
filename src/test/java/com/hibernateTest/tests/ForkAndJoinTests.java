package com.hibernateTest.tests;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by suay on 8/18/16.
 */
//doRecursiveTask(input) {
//        if (the task is small enough to be handled by a thread) {
//        compute the small task;
//        if there is a result to return, do so
//        }
//        else {
//        divide (i.e., fork) the task longo two parts
//        call compute() on first task, join() on second task, return combined results
//        }
//        }

//Points to remember:
// Create a class which extends RecursiveTask<Object> and override <V> compute
// Create 2 parts, and call fork on the first part and compute in the second and calculate the result first.join() operation sencond.compute()
// To run the code create a ForkJoinPool forkJoinPool = new ForkJoinPool(NUM_THREADS);
//Get the result by forkJoinPool.invoke(new MultiplyRecursive(1, 11));
public class ForkAndJoinTests {

    private static class MultiplyRecursive extends RecursiveTask<Long>{

        Long from, to;

        public MultiplyRecursive(long from, long to){
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            Long localRes = 1l;
            long limit = 10;
            if(to - from < limit){
                for (long i = from; i<= to; i++){
                    localRes = localRes * i;
                }
                System.out.println("local res = " + localRes);
                return localRes;
            }else{
                long midPolong = (from + to) / 2;

                MultiplyRecursive firstHalf = new MultiplyRecursive(from, midPolong);
                MultiplyRecursive secondHalf = new MultiplyRecursive(midPolong+1, to);

                firstHalf.fork();
                Long secondHalfRes = secondHalf.compute();
                System.out.println("secondHalfRes is: " + secondHalfRes);
                return firstHalf.join() * secondHalfRes;
            }
        }
    }

    @Test
    public void testMultiplyRecursive(){
//        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        Long result = forkJoinPool.invoke(new MultiplyRecursive(1, 11));
        System.out.print(result);
    }
}
