package com.gradescope.DoubleQueue.code;

/*
 * Team member names:
 * Jacob Cox
 * Prahalad Gururajan
 * Kalyaan Srinivasan
 * Steven Cabezas
 */

/**
 * IDoubleQueueContract
 * IDoubleQueue represents a FIFO queue data structure that holds Doubles.
 *
 * @initialization Ensures: [A new empty Double queue is created that holds max_queue_size items.]
 *
 * @defines: max_queue_size = Z
 *
 * @constraints: max_queue_size > 0
 *
 */
public interface IDoubleQueue {

    // This function's contracts are in the individual classes
    public void enqueue(Double val);

    /**
     * dequeueContract
     * dequeue removes the item from the front of the queue and returns it.
     *
     * @return The item removed from the front of the queue.
     *
     * @pre |self| > 0
     *
     * @post dequeue = [the item removed from the front of the queue]
     *          AND [self = #self with the item at the front of the queue removed]
     *          AND max_queue_size = #max_queue_size
     */
    public Double dequeue();

    /**
     * lengthContract
     * length gets the number of items in the queue.
     *
     * @return The number of items currently in the queue.
     *
     * @pre None
     *
     * @post length = |self| AND self = #self AND max_queue_size = #max_queue_size
     *
     */
    public int length();

    /**
     * toStringContract
     * returns a string to represent the items in the queue and their ordering
     *
     * @return A string representing the state of the queue.
     *
     * @pre None
     *
     * @post toString = [a string showing the contents of the queue] AND
     *          self = #self AND max_queue_size = #max_queue_size
     *
     */
    public String toString();
}
