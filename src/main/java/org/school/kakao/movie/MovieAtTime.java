package org.school.kakao.movie;

import java.time.LocalTime;

public class MovieAtTime extends Movie {
    private LocalTime time;

    public MovieAtTime(String title, Genre genre, LocalTime time) {
        super(title, genre);
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }
}
