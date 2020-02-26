package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int pizzasToMake;
    private int pizzasDone;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.pizzasToMake = elementNum;
        pizzasDone = 0;
    }

    @Override
    public void run() {

        while (pizzasDone < pizzasToMake) {
            Pizza pizza = new Pizza();
            pizzasDone++;
            System.out.println(Thread.currentThread().getName() + " made a(n) " + pizza);
            queue.offer(pizza);

        }

        System.out.println(Thread.currentThread().getName() + " says: job done. Time to go home.");




    }

}
