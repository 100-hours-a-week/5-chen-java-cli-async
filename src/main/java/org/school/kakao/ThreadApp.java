package org.school.kakao;

import org.school.kakao.config.AppConfig;
import org.school.kakao.food.CinemaFoodQueue;
import org.school.kakao.food.FoodConsumer;
import org.school.kakao.food.FoodProducer;
import org.school.kakao.io.OutputManager;

import java.util.LinkedList;
import java.util.List;

public class ThreadApp {
    private AppConfig appConfig;
    private List<Thread> threads;

    public ThreadApp(AppConfig appConfig) {
        this.appConfig = appConfig;
        this.threads = new LinkedList<>();
    }

    public void start(boolean watchOn) {
        foodProducerStart();
        foodConsumerStart();
        onlineUserStart();
        if (watchOn) {
            watcherStart();
        }
    }


    public void end() {
        threads.forEach(Thread::interrupt);
    }

    private void watcherStart() {
        List<CinemaFoodQueue> foodQueueList = appConfig.getFoodQueueList();
        Thread thread = new Thread(() -> {
            while (true) {
                OutputManager.render();
                StringBuilder builder = new StringBuilder();
                for (CinemaFoodQueue foodQueue : foodQueueList) {
                    String name = foodQueue.getFood().getName();
                    int size = foodQueue.size();
                    int capacity = foodQueue.getCapacity();

                    builder.append(String.format("%-8s\t : ", name));
                    for (int i = 0; i < capacity; i++) {
                        if (i < size) {
                            builder.append("░");
                        } else {
                            builder.append(" ");
                        }
                    }
                    builder.append("(")
                            .append(size)
                            .append("/")
                            .append(capacity)
                            .append(")");

                    builder.append("\n");
                }
                try {
                    System.out.println(builder);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        threads.add(thread);
    }

    private void onlineUserStart() {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new OnlineUser(appConfig.getMovies()));
            thread.start();
            threads.add(thread);
        }
    }

    private void foodConsumerStart() {
        List<CinemaFoodQueue> foodQueueList = appConfig.getFoodQueueList();
        for (CinemaFoodQueue queue : foodQueueList) {
            for (int i = 0; i < 2; i++) {
                Thread thread = new Thread(new FoodConsumer(queue));
                thread.start();
                threads.add(thread);
            }
        }
    }

    private void foodProducerStart() {
        List<CinemaFoodQueue> foodQueueList = appConfig.getFoodQueueList();
        for (CinemaFoodQueue queue : foodQueueList) {
            for (int i = 0; i < 2; i++) {
                Thread thread = new Thread(new FoodProducer(queue));
                thread.start();
                threads.add(thread);
            }
        }
    }
}
