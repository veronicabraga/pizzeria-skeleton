package org.academiadecodigo.bootcamp.concurrency;

public class Pizza {

    private Topping topping;

    public Pizza() {
        this.topping = randomTopping();
    }

    private Topping randomTopping(){
        return Topping.values()[(int)(Math.random() * Topping.values().length)];
    }

    private enum Topping {
        PINEAPPLE,
        BACON,
        SPINACH,
        CHEESE,
        ANCHOVIES,
        PEPPERONI
    }

    @Override
    public String toString() {
        return topping.name().toLowerCase() + " pizza.";
    }
}
