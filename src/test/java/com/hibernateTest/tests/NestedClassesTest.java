package com.hibernateTest.tests;

import org.hibernate.annotations.SourceType;
import org.junit.Test;

/**
 * Created by suay on 8/26/16.
 */

// note: outter and inner classes share their variables even if they are private


//    I didn't do an example of an Annonymous class but is the classic new C
public class NestedClassesTest {

    private static String parentVar = "Parents static";

    private String parentLocalVar = "Parent local";

//note: to create a new class from outside:
//NestedClassesTest.StaticClass staticInnerClass = new NestedClassesTest.StaticClass();

    static  class StaticClass {

        private static String childStaticVar = "Child static";

        private String childLocalVar = "Child local";

        //cannot access parentLocal
        void methodStatic(){
            System.out.println(parentVar);
            parentVar = "newParentStatic";
            System.out.println(parentVar);

        }
    }

//    note: to create a new class from outside you need first to create an object !!!!!!
//NestedClassesTest nestedClassesTest = new NestedClassesTest();
//    NestedClassesTest.InnerClass i = nestedClassesTest.new InnerClass();
    public class InnerClass{

        private String childInnerVar = "inner var";

//       YOu cannot declare static vars indise an inner class!!!!!!
//        private static String childStaticVar = "Child static";

        void methodInner(){
            System.out.println(parentLocalVar);
            System.out.println(parentVar);
            parentLocalVar = "newParentLocal";
            System.out.println(parentLocalVar);
        }
    }

    @Test
    public void testNestedClasses(){
        StaticClass staticClass = new StaticClass();
        staticClass.methodStatic();

        System.out.println(staticClass.childLocalVar);
        System.out.println(StaticClass.childStaticVar);

    }

    @Test
    public void testInnerClass(){
        //Sin el this tb funciona aunque en el libro ponga que no
        InnerClass innerClass = this.new InnerClass();
        innerClass.methodInner();

        System.out.println(innerClass.childInnerVar);
    }


    //local class: class inside a method, constructor or static block
    @Test
    public void testLocalClasses(){
        class LocalClass{
            private String childLocalVar = "child local var";

            void methodInner(){
                System.out.println(parentLocalVar);
                System.out.println(parentVar);
            }
        }
        LocalClass localClass = new LocalClass();
        System.out.println(localClass.childLocalVar);
    }


    @Test
    public void anonymousClasstest(){

        InnerClass i = new InnerClass(){
            public String anonymousVar = "anonymousVar";
            @Override
            void methodInner(){
                System.out.println("this my new methodInner");
                System.out.println(parentLocalVar);
                System.out.println(parentVar);
                System.out.println(anonymousVar);
                anonymousVar = "new anonyous";
                parentVar = "new parentVar";
                parentLocalVar = "new parent local var";

            }
        };
        i.methodInner();

        System.out.println(parentVar);
        System.out.println(parentLocalVar);

        //Cannot access variables redefined
//        i.anonymousVar


    }
}



