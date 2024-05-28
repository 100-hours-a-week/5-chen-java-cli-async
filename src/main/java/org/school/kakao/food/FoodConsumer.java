package org.school.kakao.food;

public class FoodConsumer implements Runnable {
    private final CinemaFoodQueue foodQueue;

    public FoodConsumer(CinemaFoodQueue foodQueue) {
        this.foodQueue = foodQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                foodQueue.consume();
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
