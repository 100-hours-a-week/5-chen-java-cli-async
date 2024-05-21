package org.school.kakao.movie;

import java.time.LocalTime;

public class ScreeningMovie extends MovieAtTime {
    Seats seats;

    public ScreeningMovie(String title, Genre genre, LocalTime time, Seats seats) {
        super(title, genre, time);
        this.seats = seats;
    }

    public Seats getSeats() {
        return seats;
    }
}
