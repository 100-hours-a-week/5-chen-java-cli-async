package org.school.kakao;

import org.school.kakao.audience.Audience;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.food.Food;
import org.school.kakao.food.FoodService;
import org.school.kakao.movie.MovieService;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.SeatGrade;

import java.util.List;

public class AppController {
    private AudienceService audienceService;
    private MovieService movieService;
    private FoodService foodService;

    public AppController(AudienceService audienceService, MovieService movieService, FoodService foodService) {
        this.audienceService = audienceService;
        this.movieService = movieService;
        this.foodService = foodService;
    }

    public void start() {
        Audience audience = audienceService.ask();
        // 영화 선택
        ScreeningMovie chosenMovie = movieService.askMovie();
        // 좌석 선택
        List<SeatGrade> seatGrades = movieService.askSeats(chosenMovie);
        // 먹거리 선택
        List<Food> chosenFoods = foodService.askFoods();
    }


}
