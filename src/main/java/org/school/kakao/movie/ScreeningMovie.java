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

    public List<SeatGrade> book(List<String> order) throws IllegalArgumentException {
        List<Seat> list = new ArrayList<>();
        for (String seatOrder : order) {
            if (seatOrder.length() != 2) {
                throw new IllegalArgumentException("형식이 틀렸습니다. : " + seatOrder);
            }
            String[] split = seatOrder.split("");
            String key = split[0].toUpperCase();
            int strNum = Integer.parseInt(split[1]);

            List<Seat> seatLane = seatMap.get(key);
            if (seatLane == null) {
                throw new IllegalArgumentException("형식이 틀렸습니다. : " + seatOrder);
            }
            Seat seat = seatLane.get(strNum - 1);
            if (seat.isOccupied()) {
                throw new IllegalArgumentException("이미 예약되었습니다. : " + seatOrder);
            }
            list.add(seat);
        }
        return list.stream().map(Seat::book).toList();
    }

    public List<List<String>> listing() {
        NavigableSet<String> keys = seatMap.descendingKeySet();
        List<List<String>> result = new LinkedList<>();
        for (String key : keys) {
            List<Seat> seats = seatMap.get(key);
            ArrayList<String> list = new ArrayList<>(seats.size());
            for (int i = 1; i <= seats.size(); i++) {
                if (seats.get(i - 1).isOccupied()) {
                    list.add("X");
                } else {
                    list.add(key + i);
                }
            }
            result.add(list);
        }
        return result;
    }
}
