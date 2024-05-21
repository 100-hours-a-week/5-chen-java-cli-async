package org.school.kakao.movie;

import java.util.*;

public class Seats {
    NavigableMap<String, List<Seat>> seatMap;

    public Seats(int silver, int gold, int platinum, int diamond) {
        this.seatMap = createSeats(silver, gold, platinum, diamond);
    }

    private static TreeMap<String, List<Seat>> createSeats(int silver, int gold, int platinum, int diamond) {
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
