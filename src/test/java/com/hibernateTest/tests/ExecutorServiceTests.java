package com.hibernateTest.tests;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by suay on 8/17/16.
 */

//execute(Runnable):
// The execute(Runnable) method takes a java.lang.Runnable object,
// and executes it asynchronously.

//submit(Runnable)
//The submit(Runnable) method also takes a Runnable implementation, but returns a Future object.

//submit(Callable)
//The submit(Callable) method is similar to the submit(Runnable) method except for the type of parameter it takes.
// The Callable instance is very similar to a Runnable except that its call() method can return a result.

//invokeAll()
//The invokeAll() method invokes all of the Callable objects you pass to it in the collection passed as parameter.
// The invokeAll() returns a list of Future objects via which you can obtain the results of the executions of each Callable.

//When you are done using the ExecutorService you should shut it down, so the threads do not keep running.

//    . If you call the get() method directly while the task is not complete, the method blocks until it completes and returns the value once available.
public class ExecutorServiceTests {

    private class MyCallable implements Callable<Integer>{
        int number;
        public MyCallable(int number){
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("Enter in  callable with number:" + number);
            Integer totalSum = 0;
            for(int i= 0;i < number; i++){
                totalSum += i;
            }
            System.out.println("Exiting callable");
            return totalSum;
        }
    }


    @Test
    public void testMyCallable() throws Exception{

        int numProcessors = Runtime.getRuntime().availableProcessors();
        int num1 = 100000000;
        int num2 = 20000000;

        MyCallable callable1 = new MyCallable(num1);
        MyCallable callable2 = new MyCallable(num2);
        Set<MyCallable> callables = new HashSet<>(Arrays.asList(callable1, callable2));
        ExecutorService es = Executors.newFixedThreadPool(numProcessors);
        List<Future<Integer>> futures = es.invokeAll(callables);
        System.out.println("going out");
        for (Future<Integer> future : futures) {
            System.out.println("result is:");
            System.out.println(future.get().toString());
        }
        es.shutdown();
    }

}
