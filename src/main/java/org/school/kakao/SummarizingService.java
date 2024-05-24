package org.school.kakao;

import org.school.kakao.food.Food;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.MovieDTO;
import org.school.kakao.movie.SeatGrade;
import org.school.kakao.pay.DiscountResult;

import java.util.List;
import java.util.stream.Collectors;

public class SummarizingService {

    public void summarizeForMovie(MovieDTO movieDTO, DiscountResult discountResult) {
        OutputManager.render();
        int resultPrice = 0;

        String seatNames = movieDTO.seatGrades().stream()
                .map(SeatGrade::toString)
                .map(str -> str + "석")
                .collect(Collectors.joining(", "));

        int seatPrice = movieDTO.seatGrades().stream()
                .map(SeatGrade::getPrice)
                .reduce(0, Integer::sum);

        OutputManager.println(seatNames);
        OutputManager.println("+ 영화 금액 = " + seatPrice);
        resultPrice += seatPrice;


        String discountNames = String.join(", ", discountResult.getNames());
        int discountedPrice = discountResult.getTotal();
        OutputManager.println(discountNames);
        OutputManager.println("- 할인 금액 = " + discountedPrice);
        resultPrice -= discountedPrice;

        OutputManager.println("= 총    액 = " + resultPrice);
    }

    public void summarizeForFood(List<Food> foods, DiscountResult discountResult) {
        OutputManager.render();
        int resultPrice = 0;

        String foodNames = foods.stream()
                .map(Food::getName)
                .collect(Collectors.joining(", "));

        int foodPrice = foods.stream()
                .map(Food::getPrice)
                .reduce(0, Integer::sum);

        OutputManager.println(foodNames);
        OutputManager.println("+ 음식 금액 = " + foodPrice);
        resultPrice += foodPrice;

        String discountNames = String.join(", ", discountResult.getNames());
        int discountedPrice = discountResult.getTotal();
        OutputManager.println(discountNames);
        OutputManager.println("- 할인 금액 = " + discountedPrice);
        resultPrice -= discountedPrice;

        OutputManager.println("= 총    액 = " + resultPrice);
    }
}
