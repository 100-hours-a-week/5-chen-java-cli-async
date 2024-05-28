package org.school.kakao.food;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CinemaFoodQueue {
    private final BlockingQueue<Food> queue;
    private final Food food;
    private final int capacity;

    public CinemaFoodQueue(Food food, int capacity) {
        this.food = food;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    public Food getFood() {
        return food;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return queue.size();
    }

    public void produce() throws InterruptedException {
        queue.put(food); // 큐가 가득 차면 대기
    }

    public Food consume() throws InterruptedException {
        return queue.take();
    }
}
