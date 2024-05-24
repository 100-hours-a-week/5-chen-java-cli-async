package org.school.kakao.config;

import org.school.kakao.Cinema;
import org.school.kakao.SummarizingService;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.food.FoodController;
import org.school.kakao.movie.MovieController;
import org.school.kakao.pay.AudienceDiscountStrategy;
import org.school.kakao.pay.DiscountService;
import org.school.kakao.pay.MovieDiscountStrategy;
import org.school.kakao.pay.TimeDiscountStrategy;
import org.school.kakao.food.Food;
import org.school.kakao.food.FoodService;
import org.school.kakao.movie.Genre;
import org.school.kakao.movie.MovieService;
import org.school.kakao.movie.ScreeningMovie;

import java.time.LocalTime;
import java.util.List;

public class AppConfig {
    public Cinema cinema() {
        return new Cinema(foodController(), movieController());
    }

    private FoodController foodController() {
        return new FoodController(foodService(), discountService(), summarizingService());
    }

    private MovieController movieController() {
        return new MovieController(audienceService(), movieService(), discountService(), summarizingService());
    }

    public AudienceService audienceService() {
        return new AudienceService();
    }

    public MovieService movieService() {
        List<ScreeningMovie> movies = List.of(
                new ScreeningMovie("범죄도시4", Genre.ACTION, LocalTime.of(19, 30), 5),
                new ScreeningMovie("쿵푸팬더4", Genre.ADVENTURE, LocalTime.of(20, 30), 6)
        );
        return new MovieService(movies);
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
