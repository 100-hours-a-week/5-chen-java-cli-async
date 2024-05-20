package org.school.kakao;

import org.school.kakao.audience.Audience;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.discount.DiscountItem;
import org.school.kakao.discount.DiscountResult;
import org.school.kakao.discount.DiscountService;
import org.school.kakao.discount.DiscountableItems;
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
    private DiscountService discountService;

    public AppController(AudienceService audienceService, MovieService movieService, FoodService foodService, DiscountService discountService) {
        this.audienceService = audienceService;
        this.movieService = movieService;
        this.foodService = foodService;
        this.discountService = discountService;
    }

    public void start() {
        Audience audience = audienceService.ask();
        // 영화 선택
        ScreeningMovie chosenMovie = movieService.askMovie();
        // 좌석 선택
        List<SeatGrade> seatGrades = movieService.askSeats(chosenMovie);
        // 먹거리 선택
        List<Food> chosenFoods = foodService.askFoods();

        DiscountResult discount = discountService.discount(new DiscountableItems(audience, chosenFoods, chosenMovie));
        List<DiscountItem> discountItems = discount.getDiscountItems();
        for (DiscountItem discountItem : discountItems) {
            System.out.println(discountItem.getName() + " : " + discountItem.getAmount());
        }
    }


}
