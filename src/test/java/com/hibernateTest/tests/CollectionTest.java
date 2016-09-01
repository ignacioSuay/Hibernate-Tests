package com.hibernateTest.tests;

import org.junit.Test;

import java.util.*;

/**
 * Created by suay on 9/1/16.
 */
public class CollectionTest {

    @Test
    //Check that collections accept null values
    public void testCollectionNull(){
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        set.add(null);
        list.add(null);
        map.put(null,null);

        set.add(null);
        list.add(null);
        map.put(null,null);
    }

//    Algorithm           ArrayList   LinkedList
//    seek front            O(1)         O(1)
//    seek back             O(1)         O(1)
//    seek to index         O(1)         O(N)
//    insert at front       O(N)         O(1)
//    insert at back        O(1)         O(1)
//    insert after an item  O(N)         O(1)

// Linked list use more memory for the implementation
// Vector is equivalent  to ArrayList but syncronized

//When to use linkedList: If you frequently add elements to the beginning of the List or iterate over the List to delete
// elements from its interior, you should consider using LinkedList

// Oracle recommendation:  If you think you want to use a LinkedList, measure the performance of your application with
// both LinkedList and ArrayList before making your choice; ArrayList is usually faster.

//    CopyOnWriteArrayList is a List implementation backed up by a copy-on-write array. This implementation is similar
// in nature to CopyOnWriteArraySet. No synchronization is necessary, even during iteration, and iterators are guaranteed
// never to throw ConcurrentModificationException. This implementation is well suited to maintaining event-handler lists,
// in which change is infrequent, and traversal is frequent and potentially time-consuming.

}
