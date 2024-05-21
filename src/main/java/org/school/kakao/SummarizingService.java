package org.school.kakao;

import org.school.kakao.food.Food;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.SeatGrade;

public class SummarizingService {
    public SummarizingService() {
    }

    public void summarize() {
        OutputManager.render();
        AppContext context = AppContext.getInstance();

        int seatPrice = context.getSeatGrades().stream()
                .map(SeatGrade::getPrice)
                .reduce(0, Integer::sum);
        int foodPrice = context.getFoods().stream()
                .map(Food::getPrice)
                .reduce(0, Integer::sum);
        int discountedPrice = context.getDiscountResult().getTotal();

        System.out.println("+ 영화 금액 = " + seatPrice);
        System.out.println("+ 음식 금액 = " + foodPrice);
        System.out.println("- 할인 금액 = " + discountedPrice);
        System.out.println("= 총    액 = " + (seatPrice + foodPrice - discountedPrice));
    }
}
