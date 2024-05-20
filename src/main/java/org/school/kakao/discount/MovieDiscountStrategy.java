package org.school.kakao.discount;

import org.school.kakao.movie.Movie;

public class MovieDiscountStrategy<T extends Movie> implements DiscountStrategy<T> {
    @Override
    public boolean canApply(T movie) {
        return false;
    }

    @Override
    public DiscountResult discount(T movie) {
        return null;
    }
}
