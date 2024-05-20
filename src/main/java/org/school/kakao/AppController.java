package org.school.kakao;

import org.school.kakao.audience.AudienceService;
import org.school.kakao.discount.DiscountService;
import org.school.kakao.food.FoodService;
import org.school.kakao.movie.MovieService;
import org.school.kakao.movie.SeatService;

public class AppController {
    private final AudienceService audienceService;
    private final MovieService movieService;
    private final SeatService seatService;
    private final FoodService foodService;
    private final DiscountService discountService;
    private final SummarizingService summarizingService;

    public AppController(AudienceService audienceService, MovieService movieService, SeatService seatService, FoodService foodService, DiscountService discountService, SummarizingService summarizingService) {
        this.audienceService = audienceService;
        this.movieService = movieService;
        this.seatService = seatService;
        this.foodService = foodService;
        this.discountService = discountService;
        this.summarizingService = summarizingService;
    }


    public void start() {
        AppContext.newInstance();
        // 사람 조사
        audienceService.ask();
        // 영화 선택
        movieService.ask();
        // 좌석 선택
        seatService.ask();
        // 먹거리 선택
        foodService.ask();
        // 할인
        discountService.discount();
        // 총 계
        summarizingService.summarize();
    }


}
