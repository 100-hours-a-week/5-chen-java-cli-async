package org.school.kakao.config;

import org.school.kakao.Cinema;
import org.school.kakao.SummarizingService;
import org.school.kakao.ThreadUser;
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
    private List<ScreeningMovie> movies;

    public AppConfig() {
        this.movies = List.of(
                new ScreeningMovie("범죄도시4", Genre.ACTION, LocalTime.of(19, 30), 5),
                new ScreeningMovie("쿵푸팬더4", Genre.ADVENTURE, LocalTime.of(20, 30), 6)
        );
    }

    public Cinema cinema() {
        return new Cinema(foodController(), movieController());
    }

    public ThreadUser threadUser() {
        return new ThreadUser(this.movies);
    }

    private FoodController foodController() {
        return new FoodController(foodService(), discountService(), summarizingService());
    }

    private MovieController movieController() {
        return new MovieController(audienceService(), movieService(), discountService(), summarizingService());
    }

    private AudienceService audienceService() {
        return new AudienceService();
    }

    private MovieService movieService() {
        return new MovieService(this.movies);
    }

    private FoodService foodService() {
        return new FoodService(
                List.of(
                        new Food("팝콘", 1000),
                        new Food("핫도그", 2000),
                        new Food("아이스크림", 3000),
                        new Food("콜라", 4000)
                ));
    }

    private DiscountService discountService() {
        return new DiscountService(
                new MovieDiscountStrategy(),
                new TimeDiscountStrategy(),
                new AudienceDiscountStrategy()
        );
    }

    private SummarizingService summarizingService() {
        return new SummarizingService();
    }
}
