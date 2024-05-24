package org.school.kakao.movie;

import java.time.LocalTime;
import java.util.List;

public class CinemaFront extends ScreeningMovie {
    public CinemaFront(String title, Genre genre, LocalTime time, int seatAmount) {
        super(title, genre, time, seatAmount);
    }

    @Override
    public List<SeatGrade> book(List<String> order) throws IllegalArgumentException {
        return super.book(order);
    }
}
