package org.school.kakao.discount;

import org.school.kakao.audience.Audience;
import org.school.kakao.food.Food;
import org.school.kakao.movie.MovieAtTime;

import java.util.List;

public class DiscountableItems {
    private final Audience audience;
    private final List<Food> foods;
    private final MovieAtTime movie;

    public DiscountableItems(Audience audience, List<Food> foods, MovieAtTime movie) {
        this.audience = audience;
        this.foods = foods;
        this.movie = movie;
    }

    public Audience getAudience() {
        return audience;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public MovieAtTime getMovie() {
        return movie;
    }
}
