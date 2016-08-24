package com.hibernateTest.tests;

import org.junit.Test;

/**
 * Created by suay on 8/24/16.
 */

//notes:
// CheckedExceptions: extend from Exception, are the ones you are force to do sth when a method throws them e.g IOException
// UncheckedExceptions: extends from RuntimeException, if a method throws them you can manage them or not
//
//
//Overriding a method which throws exception:
// If it is a RuntimeException you don't have to add it to the method signature
// If it is a CheckedException the method signature will need to have the same exception or a subclass but NEVER a more general one
//An overriding method cannot declare more checked exceptions in the throws clause
//than the list of exceptions declared in the throws clause of the base method
//    If a method is declared in two or more interfaces, and if that method declares to
//throw different exceptions in the throws clause, the method implementation should
//        list all of these exceptions.
//
// If you multiple catchs and you put first a more general and then a more specific you will get compiler error
//
//try-with-resource
// don't close it twice
// When you use try with resource, the resources will close in opposite order of creation


//In a try-with-resources statement, there might be more than one exception that could get thrown; for
//        example, one within the try block, one within the catch block, and another one within the finally block.
//        However, only one exception can be caught, so the other exception(s) will be listed as suppressed
//        exceptions. From a given exception object, you can use the method getSuppressed() to get the list of
//        suppressed exception

public class ExceptionTests {




    @Test
    public void testRuntimeEx(){
        try {
            throwRuntimeException();
        }catch (IllegalArgumentException e){
            System.out.println("Exception is catched here");
            e.printStackTrace();
        }
    }

    //    If a method does not have a throws clause, it does not mean it cannot throw any
//            exceptions; it just means it cannot throw any checked exceptions.
    private void throwRuntimeException(){
        //you can throw RuntimeExceptions in th
        throw new IllegalArgumentException();
    }

    @Test
    public void testMyException() throws MyException {
        throw new MyException();
    }


    private class MyException extends Exception{
        public MyException(){
            super("this is my exception");
        }
    }
}
