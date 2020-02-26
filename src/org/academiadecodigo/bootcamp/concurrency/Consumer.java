package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int pizzasToConsume;
    private int pizzasConsumed;
    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.pizzasToConsume = elementNum;
    }

    @Override
    public void run() {

        while (pizzasConsumed < pizzasToConsume) {
            queue.poll();
            System.out.println(Thread.currentThread().getName() + " ate a(n) " + queue.poll());
        }

        System.out.println(Thread.currentThread().getName() + " have eaten his " + pizzasToConsume + " pizzas.");
    }

}
