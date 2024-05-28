package org.school.kakao.food;

public class FoodProducer implements Runnable {
    private final CinemaFoodQueue foodQueue;

    public FoodProducer(CinemaFoodQueue foodQueue) {
        this.foodQueue = foodQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                foodQueue.produce();
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
