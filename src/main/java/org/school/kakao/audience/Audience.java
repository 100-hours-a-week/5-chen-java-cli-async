package org.school.kakao.audience;

import org.school.kakao.movie.Movie;
import org.school.kakao.movie.ScreeningMovie;

import java.util.List;

public class Audience {
    private List<Person> people;
    private ScreeningMovie movie;

    public Audience(List<Person> people) {
        this.people = people;
    }
}
