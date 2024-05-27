package org.school.kakao;

import org.school.kakao.movie.ScreeningMovie;

import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;

public class ThreadUser {
    private static final int BOOK_TRY = 300;

    private List<ScreeningMovie> movies;
    private List<Thread> threads;

    public ThreadUser(List<ScreeningMovie> movies) {
        this.movies = movies;
        this.threads = new ArrayList<>();
    }

    public void start() {
        Runnable reserveTask = () -> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < BOOK_TRY; i++) {
                    ScreeningMovie movie = movies.get(getRandomMovieNumber(movies));
                    List<List<String>> seats = movie.listing();

                    String lane = getRandomLaneNumber(seats);
                    int seatNumber = getRandomSeatNumber(seats);

                    movie.book(List.of(lane + seatNumber));

                }
            } catch (IllegalArgumentException ignored) {
            } catch (InterruptedException exitr) {
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(reserveTask);
            thread.start();
            threads.add(thread);
        }

    }

    private static int getRandomSeatNumber(List<List<String>> seats) {
        int seatSize = seats.get(0).size();
        double seatNumber = Math.random() * seatSize;
        return (int) Math.ceil(seatNumber);
    }

    private static String getRandomLaneNumber(List<List<String>> seats) {
        int laneSize = seats.size();
        double laneNumber = 65 + (Math.random() * laneSize);
        char lane = (char) Math.floor(laneNumber);
        return String.valueOf(lane);
    }

    private static int getRandomMovieNumber(List<ScreeningMovie> movies) {
        int movieSize = movies.size();
        double movieNumber = Math.random() * movieSize;
        return (int) Math.floor(movieNumber);
    }

    public void end() {
        threads.stream().forEach(Thread::interrupt);
    }
}
