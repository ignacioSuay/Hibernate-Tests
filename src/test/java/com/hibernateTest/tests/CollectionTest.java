package com.hibernateTest.tests;

import org.junit.Test;

import java.util.*;

/**
 * Created by suay on 9/1/16.
 */

/**
 * Collection:
 * - Set: collection with no duplicates and no positional access
 *  * HashSet: Unordered set but much faster than treeset. No thread safe.
 *  * TreeSet: Ordered Set but slower than hashset, it orders using comparable. No thread safe.
 *  * LinkedHashSet:Ordered by insertion. performance close to hashset. No thread safe.
 *  * EnumSet:  high-performance Set implementation for enum types. All of the members of an enum set must be of the same enum type. eg EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
 *  * CopyOnWriteArraySet:  a Set implementation backed up by a copy-on-write array. It is thread safe.
 *
 *
 * -List: collection which allows duplicates and positional access
 *  * ArrayList: constant-time positional access and is just plain fast
 *  * Vector: As ArrayList but syncronized. It is thread safe.
 *  * LinkedList: Ordered by insertion. Better for add elements to the beginning of the List or iterate over the List to delete elements from its interior
 *
 * ArrayList vs Vector:
 *  - If reads are much more common compared to writes then you would tend to prefer CopyOnWriteArrayList, since the array copying overhead is only incurred on writes.
 *  - If the size of the Array is small, then the cost of making array copies will also be small, hence this will favour CopyOnWriteArrayList over Vector.
 *  - Basically:  if you have much more reads than writes, use CopyOnWriteArrayList, otherwise use Vector
 *
 *  - Queue: Good if you are planning to add/remove at the beginning, specially for FIFO queues
 *      * PriorityQueue: Ordered by comparable or by adding a comparator. No thread safe.
 *      * Concurrent Implementations are LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue
 *
 *  - Dequeue: Good if you are planning to add/remove at the beginning OR/AND at the end, specially for  LIFO queues.
 *    * LinkedList: check above.No thread safe.More flexible, Null elements are allowed in the LinkedList implementation but not in the ArrayDeque implementation. The LinkedList implementation consumes more memory than the ArrayDeque implementation
 *    * ArrayDeque: The ArrayDeque class is the resizable array.ArrayDeque is more efficient than the LinkedList
 *
 * Comparable vs Comparator: you implement comparable with the method int compateTo(Object obj) and is the natural order of the class.
 *  if you want a particular order you create a new class which implements comparator and the methos is int compare(Object o1, Object o2){}
 *
 *
 *  Map: Map doesn't extend from Collection!
 *  * HashMap: fast but Unordered
 *  * TreeMap : slow and ordered by comparable or by passing a comparator
 *  * LinkedHasMap: faster and ordered by insertion by default. There is sth thath LinkedHashSet doesn't have!!:
 *          When you create a LinkedHashMap, you can order it based on key access rather than insertion.
 *
 *  * EnumMap: for use with EnumKeys.
 *  * WeakHashMap is an implementation of the Map interface that stores only weak references to its keys. Storing only weak references allows a key-value pair to be garbage-collected when its key is no longer referenced outside of the WeakHashMap.
 *  *  ConcurrentHashMap: Threadsafe hash map.
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
