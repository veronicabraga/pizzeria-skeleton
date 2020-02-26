package org.academiadecodigo.bootcamp.concurrency.bqueue;

import org.academiadecodigo.bootcamp.concurrency.Pizza;

import java.util.PriorityQueue;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private PriorityQueue<T> queue;
    private int limit;
    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.queue = new PriorityQueue<>();
        this.limit = limit;


    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (getSize() == getLimit()) {
            try {
                System.out.println("There Bqueue is full!" + Thread.currentThread().getName() + " must wait to add a pizza.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getSize() + "pizzas no balcao");
        System.out.println(queue.offer(data));

        notifyAll();
        System.out.println("Pizza added to the BQueue, it contains: " + getSize() + " pizzas.");


    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        while (getSize() == 0) {
            try {
                System.out.println("The Bqueue is empty! " + Thread.currentThread().getName() + " must wait until there are pizzas.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T pizza = queue.poll();
        notifyAll();

        System.out.println("Pizza removed from the BQueue, it contains: " + getSize() + " pizzas.");
        return pizza;




    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {

       return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

       return limit;

    }

}
