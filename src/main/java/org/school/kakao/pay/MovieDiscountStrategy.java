package org.school.kakao.pay;

import org.school.kakao.movie.Genre;

import java.util.List;

public class MovieDiscountStrategy implements DiscountStrategy<Genre> {

    @Override
    public DiscountResult discount(Genre genre) {
        if (Genre.ACTION.equals(genre)) {
            return new DiscountResult(List.of(new DiscountItem("액션 영화 할인", 1000)));
        }
        return new DiscountResult();
    }
}
