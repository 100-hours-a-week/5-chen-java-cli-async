package org.school.kakao;

import org.school.kakao.food.Food;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.SeatGrade;

import java.util.stream.Collectors;

public class SummarizingService {
    public SummarizingService() {
    }

    public void summarize() {
        OutputManager.render();
        AppContext context = AppContext.getInstance();

        String seatNames = context.getSeatGrades().stream()
                .map(SeatGrade::toString)
                .map(str -> str + "석")
                .collect(Collectors.joining(", "));

        int seatPrice = context.getSeatGrades().stream()
                .map(SeatGrade::getPrice)
                .reduce(0, Integer::sum);

        String foodNames = context.getFoods().stream()
                .map(Food::getName)
                .collect(Collectors.joining(", "));

        int foodPrice = context.getFoods().stream()
                .map(Food::getPrice)
                .reduce(0, Integer::sum);

        String discountNames = String.join(", ", context.getDiscountResult().getNames());
        int discountedPrice = context.getDiscountResult().getTotal();


        OutputManager.println(seatNames);
        OutputManager.println("+ 영화 금액 = " + seatPrice);
        OutputManager.println(foodNames);
        OutputManager.println("+ 음식 금액 = " + foodPrice);
        OutputManager.println(discountNames);
        OutputManager.println("- 할인 금액 = " + discountedPrice);
        OutputManager.println("= 총    액 = " + (seatPrice + foodPrice - discountedPrice));
    }
}
