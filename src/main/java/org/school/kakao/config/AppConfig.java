package org.school.kakao.config;

import org.school.kakao.AppController;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.food.Food;
import org.school.kakao.food.FoodService;
import org.school.kakao.movie.Genre;
import org.school.kakao.movie.MovieService;
import org.school.kakao.movie.ScreeningMovie;

import java.time.LocalTime;
import java.util.List;

public class AppConfig {
    public AppController appController() {
        return new AppController(
                audienceService(),
                cinemaService(),
                foodService()
        );
    }

    public AudienceService audienceService() {
        return new AudienceService();
    }

    public MovieService cinemaService() {
        return new MovieService(
                List.of(
                        new ScreeningMovie("범죄도시4", Genre.ACTION, LocalTime.of(19, 30)),
                        new ScreeningMovie("쿵푸팬더4", Genre.ADVENTURE, LocalTime.of(20, 30))
                )
        );
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
}
