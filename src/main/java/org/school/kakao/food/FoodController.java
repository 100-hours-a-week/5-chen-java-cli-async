package org.school.kakao.food;

import org.school.kakao.SummarizingService;
import org.school.kakao.pay.DiscountResult;
import org.school.kakao.pay.DiscountService;

import java.util.List;

public class FoodController {
    private final FoodService foodService;
    private final DiscountService discountService;
    private final SummarizingService summarizingService;

    public FoodController(FoodService foodService, DiscountService discountService, SummarizingService summarizingService) {
        this.foodService = foodService;
        this.discountService = discountService;
        this.summarizingService = summarizingService;
    }

    public void start() {
        // 먹거리 선택
        List<Food> foods = foodService.ask();

        DiscountResult discountResult = discountService.discountForFood(foods);

        summarizingService.summarizeForFood(foods, discountResult);
    }
}
