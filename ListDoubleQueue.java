package com.gradescope.DoubleQueue.code;

/*
 * Team member names:
 * Jacob Cox
 * Prahalad Gururajan
 * Kalyaan Srinivasan
 * Steven Cabezas
 */

import java.util.ArrayList;

/**ListDoubleQueueContract
 * List implementation for the Double queue.
 *
 * @invariant: maxListSize > 0 AND |self| <= maxListSize
 *              
 * @corresponds: max_queue_size = maxListSize
 *
 */
public class ListDoubleQueue implements IDoubleQueue
{
    private ArrayList<Double> LQueue;
    private int maxListSize;

    /**ListDoubleQueueConstructorContact
     * Initializes a new ListDoubleQueue with the given maximum size.
     *
     * @param maxSize max size of the list
     *
     * @pre maxSize > 0
     *
     * @post maxListSize = maxSize AND self = new ArrayList<Double>()
     *
     */
    public ListDoubleQueue(int maxSize)
    {
        this.LQueue = new ArrayList<Double>();
        this.maxListSize = maxSize;
    }

    /**enqueueContact
     * Adds an element to the ListDoubleQueue.
     *
     * @param val The Double value to be added to the queue.
     *
     * @pre |self| < maxListSize
     *
     * @post [self = #self with val added to the tail of the list] AND maxListSize = #maxListSize
     *
     */
    @Override
    public void enqueue(Double val)
    {
        if(LQueue.size() == this.maxListSize)
            LQueue.set(this.maxListSize-1, val);
        else
            LQueue.add(val);
    }

    //Note: The below 3 functions intentionally do not have contracts. You do not need to add them.

    @Override
    public Double dequeue()
    {
        return LQueue.remove(0);
    }


    @Override
    public int length()
    {
        return LQueue.size();
    }


    public String toString()
    {
        String ret = "";
        for(Double d : LQueue)
        {
            ret += ("[" + d + "] ");
        }
        return ret;
    }

}
