package org.school.kakao.pay;

import org.school.kakao.AppContext;
import org.school.kakao.audience.Audience;
import org.school.kakao.food.Food;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.MovieAtTime;
import org.school.kakao.movie.MovieDTO;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class DiscountService {
    private final MovieDiscountStrategy movieDiscountStrategy;
    private final TimeDiscountStrategy timeDiscountStrategy;
    private final AudienceDiscountStrategy audienceDiscountStrategy;

    public DiscountService(MovieDiscountStrategy movieDiscountStrategy, TimeDiscountStrategy timeDiscountStrategy, AudienceDiscountStrategy audienceDiscountStrategy) {
        this.movieDiscountStrategy = movieDiscountStrategy;
        this.timeDiscountStrategy = timeDiscountStrategy;
        this.audienceDiscountStrategy = audienceDiscountStrategy;
    }

    public DiscountResult discountForMovie(Audience audience, MovieDTO movie) {
        return Stream.of(
                audienceDiscountStrategy.discount(audience),
                timeDiscountStrategy.discount(movie.time()),
                movieDiscountStrategy.discount(movie.genre())
        ).collect(DiscountResult::new, DiscountResult::addAll, DiscountResult::addAll);
    }

    public DiscountResult discountForFood(List<Food> food) {
        return new DiscountResult();
    }
}
