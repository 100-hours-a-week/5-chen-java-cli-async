package org.school.kakao.movie;

import java.time.LocalTime;
import java.util.*;

public class ScreeningMovie extends MovieAtTime {
    NavigableMap<String, List<Seat>> seatMap;

    public ScreeningMovie(String title, Genre genre, LocalTime time, int seatAmount) {
        super(title, genre, time);
        this.seatMap = createSeats(seatAmount);
    }

    private static TreeMap<String, List<Seat>> createSeats(int seatAmount) {
        List<Seat> silverSeats = new ArrayList<>();
        List<Seat> goldSeats = new ArrayList<>();
        List<Seat> platinumSeats = new ArrayList<>();
        List<Seat> diamondSeats = new ArrayList<>();
        for (int i = 0; i < seatAmount; i++) {
            silverSeats.add(new Seat(SeatGrade.SILVER));
            goldSeats.add(new Seat(SeatGrade.GOLD));
            platinumSeats.add(new Seat(SeatGrade.PLATINUM));
            diamondSeats.add(new Seat(SeatGrade.DIAMOND));
        }

        TreeMap<String, List<Seat>> temp = new TreeMap<>();
        temp.put("A", silverSeats);
        temp.put("B", goldSeats);
        temp.put("C", platinumSeats);
        temp.put("D", diamondSeats);
        return temp;
    }

    public List<SeatGrade> book(List<String> order) {
        return order.stream()
                .map(str -> {
                    String[] split = str.split("");
                    String key = split[0].toUpperCase();
                    int strNum = Integer.parseInt(split[1]);

                    List<Seat> seatLane = seatMap.get(key);
                    return seatLane.get(strNum - 1);
                })
                .map(Seat::book)
                .toList();
    }

    public List<List<String>> listing() {
        NavigableSet<String> keys = seatMap.descendingKeySet();
        List<List<String>> result = new LinkedList<>();
        for (String key : keys) {
            int size = seatMap.get(key).size();
            ArrayList<String> list = new ArrayList<>(size);
            for (int i = 1; i <= size; i++) {
                list.add(key + i);
            }
            result.add(list);
        }
        return result;
    }
}
