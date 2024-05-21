package org.school.kakao.discount;

import org.school.kakao.AppContext;
import org.school.kakao.audience.Audience;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.MovieAtTime;

import java.time.LocalTime;
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

    public void discount() {
        OutputManager.render();
        AppContext appContext = AppContext.getInstance();
        MovieAtTime movie = appContext.getScreeningMovie();
        Audience audience = appContext.getAudience();
        LocalTime movieTime = movie.getTime();

        DiscountResult result = Stream.of(
                audienceDiscountStrategy.discount(audience),
                timeDiscountStrategy.discount(movieTime),
                movieDiscountStrategy.discount(movie)
        ).collect(DiscountResult::new, DiscountResult::addAll, DiscountResult::addAll);

        appContext.setDiscountResult(result);
    }
}
