package org.school.kakao.config;

import org.school.kakao.AppController;
import org.school.kakao.SummarizingService;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.discount.AudienceDiscountStrategy;
import org.school.kakao.discount.DiscountService;
import org.school.kakao.discount.MovieDiscountStrategy;
import org.school.kakao.discount.TimeDiscountStrategy;
import org.school.kakao.food.Food;
import org.school.kakao.food.FoodService;
import org.school.kakao.movie.Genre;
import org.school.kakao.movie.MovieService;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.SeatService;

import java.time.LocalTime;
import java.util.List;

public class AppConfig {
    public AppController appController() {
        return new AppController(
                audienceService(),
                movieService(),
                seatService(),
                foodService(),
                discountService(),
                summarizingService()
        );
    }

    public AudienceService audienceService() {
        return new AudienceService();
    }

    public MovieService movieService() {
        return new MovieService(
                List.of(
                        new ScreeningMovie("범죄도시4", Genre.ACTION, LocalTime.of(19, 30)),
                        new ScreeningMovie("쿵푸팬더4", Genre.ADVENTURE, LocalTime.of(20, 30))
                )
        );
    }

    public SeatService seatService() {
        return new SeatService();
    }

    public FoodService foodService() {
        return new FoodService(
                List.of(
                        new Food("팝콘", 1000),
                        new Food("핫도그", 2000),
                        new Food("아이스크림", 3000),
                        new Food("콜라", 4000)
                ));
    }

    public DiscountService discountService() {
        return new DiscountService(
                new MovieDiscountStrategy(),
                new TimeDiscountStrategy(),
                new AudienceDiscountStrategy()
        );
    }

    public SummarizingService summarizingService() {
        return new SummarizingService();
    }
}
