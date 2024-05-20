package org.school.kakao.discount;

import org.school.kakao.movie.MovieAtTime;

import java.util.List;
import java.util.stream.Stream;

public class DiscountService {
    private MovieDiscountStrategy movieDiscountStrategy;
    private TimeDiscountStrategy timeDiscountStrategy;
    private AudienceDiscountStrategy audienceDiscountStrategy;

    public DiscountService(MovieDiscountStrategy movieDiscountStrategy, TimeDiscountStrategy timeDiscountStrategy, AudienceDiscountStrategy audienceDiscountStrategy) {
        this.movieDiscountStrategy = movieDiscountStrategy;
        this.timeDiscountStrategy = timeDiscountStrategy;
        this.audienceDiscountStrategy = audienceDiscountStrategy;
    }

    public DiscountResult discount(DiscountableItems items) {
        MovieAtTime movie = items.getMovie();
        DiscountResult result = Stream.of(
                audienceDiscountStrategy.discount(items.getAudience()),
                timeDiscountStrategy.discount(movie.getTime()),
                movieDiscountStrategy.discount(movie)
        ).collect(DiscountResult::new, DiscountResult::addAll, DiscountResult::addAll);

        List<DiscountItem> discountItems = result.getDiscountItems();
        for (DiscountItem discountItem : discountItems) {
            System.out.println(discountItem.getName() + " : " + discountItem.getAmount());
        }
        return result;
    }
}
