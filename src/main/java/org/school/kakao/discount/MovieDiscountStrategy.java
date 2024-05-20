package org.school.kakao.discount;

import org.school.kakao.movie.Genre;
import org.school.kakao.movie.Movie;

import java.util.List;

public class MovieDiscountStrategy implements DiscountStrategy<Movie> {

    @Override
    public DiscountResult discount(Movie movie) {
        if (Genre.ACTION.equals(movie.getGenre())) {
            return new DiscountResult(List.of(new DiscountItem("액션 영화 할인", 1000)));
        }
        return new DiscountResult();
    }
}
