package com.gradescope.DoubleQueue.code;

/*
 * Team member names:
 * Jacob Cox
 * Prahalad Gururajan
 * Kalyaan Srinivasan
 * Steven Cabezas
 */

/**ArrayDoubleQueueContract
 * Array implementation for the Double queue.
 *
 * @invariant: queueMaxSize > 0
 *
 * @corresponds: max_queue_size = queueMaxSize
 *
 */
public class ArrayDoubleQueue implements IDoubleQueue
{
    private Double[] queue;
    private int queueMaxSize;

    /**ArrayDoubleQueueConstructorContact
     * Constructor for the arrayListDouble queue.
     *
     * @param maxSize max size of the array
     *
     * @pre maxSize > 0
     *
     * @post queueMaxSize = maxSize AND self = new Double[queueMaxSize].
     *
     */
    public ArrayDoubleQueue(int maxSize)
    {
        // set the max size for the queue
        queueMaxSize = maxSize;
        // create an array with that size desu
        queue = new Double[queueMaxSize];
    }

    /**enqueueContact
     * Enqueue adds an item to the queue.
     *
     * @param val the Double to be added
     *
     * @pre |self| < queueMaxSize
     *
     * @post [self = #self with val added to left-most unoccupied index] AND queueMaxSize = #queueMaxSize
     *
     */
    @Override
    public void enqueue(Double val)
    {
        // get queue length
        int queueLength = length();

        // if the queue is full, index the last element and overwrite it with the new value
        // otherwise, go to the back index and add the new item there.
        queue[(queueLength == queueMaxSize) ? queueLength-1 : queueLength] = val;
    }

    //Note: The below 3 functions intentionally do not have contracts. You do not need to add them.

    @Override
    public Double dequeue()
    {

        // last index in the array to contain a (back) value
        int queueBackIndex = length()-1;

        // get the first (front) item in the queue
        Double removed = queue[0];

        // loop until the back of the queue and push each element up
        for (int i = 0; i < queueBackIndex; i++)
        {
            // replace the current element with the one after it
            // this starts with the element we're removing, so it has
            // the same effect as pushing all the other values to the front
            queue[i] = queue[i+1];
        }

        // set the old position of the last element that got moved up to null
        // state relied on by future enqueue and dequeue calls.
        queue[queueBackIndex] = null;

        return removed;
    }

    @Override
    public int length()
    {
        int queueLength = 0;
        // iterate until we find the first empty space or reach the end of the list
        // in either case, iteration (and counting) stops when the values do
        for (; (queueLength < queueMaxSize) && (queue[queueLength] != null); queueLength++);

        return queueLength;
    }

    public String toString()
    {
        // get the length of the queue so we know when to stop iterating
        /* THIS IS A BETTER WAY TO DO THIS! NO [null] ! THANKS GRADESCOPE! */
        int queueLength = length();
        String ret = "";

        // iterate through the whole array for NO REASON index and print it with pretty formatting
        for (int i = 0; i < queueMaxSize; i++)
        {
            ret += ("[" + queue[i] + "] ");
        }

        return ret;
    }

    //-----------------Ignore the functions below this line-----------------------
    public int getQueueMaxSize()
    {
        return this.queueMaxSize;
    }

    public Double[] getQueue()
    {
        return this.queue;
    }
}
