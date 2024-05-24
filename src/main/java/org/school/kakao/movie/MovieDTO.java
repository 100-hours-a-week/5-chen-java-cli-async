package org.school.kakao.movie;

import java.time.LocalTime;
import java.util.List;

public record MovieDTO(
        String title,
        LocalTime time,
        Genre genre,
        List<SeatGrade> seatGrades
) {
    public MovieDTO(MovieAtTime movie, List<SeatGrade> seatGrades) {
        this(movie.getTitle(), movie.getTime(), movie.getGenre(), seatGrades);
    }
}
