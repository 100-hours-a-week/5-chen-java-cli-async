package org.school.kakao.movie;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningMovie extends MovieAtTime {
    Map<String, List<Seat>> seats;

    public ScreeningMovie(String title, Genre genre, LocalTime time) {
        super(title, genre, time);
        this.seats = new HashMap<>();
        this.seats = createSeats(5, 5, 5, 5);
    }

    private static Map<String, List<Seat>> createSeats(int silver, int gold, int platinum, int diamond) {
        List<Seat> silverSeats = new ArrayList<>();
        for (int i = 0; i < silver; i++) {
            silverSeats.add(new Seat(SeatGrade.SILVER));
        }

        List<Seat> goldSeats = new ArrayList<>();
        for (int i = 0; i < gold; i++) {
            goldSeats.add(new Seat(SeatGrade.GOLD));
        }

        List<Seat> platinumSeats = new ArrayList<>();
        for (int i = 0; i < platinum; i++) {
            platinumSeats.add(new Seat(SeatGrade.PLATINUM));
        }

        List<Seat> diamondSeats = new ArrayList<>();
        for (int i = 0; i < diamond; i++) {
            diamondSeats.add(new Seat(SeatGrade.DIAMOND));
        }
        return Map.of(
                "A", silverSeats,
                "B", goldSeats,
                "C", platinumSeats,
                "D", diamondSeats
        );
    }
}
