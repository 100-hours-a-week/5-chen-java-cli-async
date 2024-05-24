package org.school.kakao;

import org.school.kakao.movie.ScreeningMovie;

import java.util.List;

public class ThreadUser {
    private List<ScreeningMovie> movies;

    public ThreadUser(List<ScreeningMovie> movies) {
        this.movies = movies;
    }

    public void start() {
        Thread threadUser = new Thread(() -> {
            while (true) {
                for (ScreeningMovie movie : movies) {
                    List<List<String>> seats = movie.listing();
                    String lane = getRandomLaneNumber(seats);
                    int seatNumber = getRandomSeatNumber(seats);

                    try {
                        movie.book(List.of(lane + seatNumber));
                    } catch (IllegalArgumentException ignored) {
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                }
            }
        });
        threadUser.start();
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
}
