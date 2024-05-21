package org.school.kakao.food;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;
import java.util.stream.Stream;

public class FoodService {
    private List<Food> foods;

    public FoodService(List<Food> foods) {
        this.foods = foods;
    }

    public void ask() {
        OutputManager.render();
        for (int i = 1; i <= foods.size(); i++) {
            Food food = foods.get(i - 1);
            OutputManager.println(i + " : " + food.getName() + " " + food.getPrice());
        }
        List<Food> chosenFoods = choiceFoods(InputManager.nextLine("먹거리 선택하시겠습니까? (쉼표로 구분)"));
        AppContext.getInstance().setFoods(chosenFoods);
    }

    private List<Food> choiceFoods(String orderFromCustomer) throws IllegalArgumentException {
        if (orderFromCustomer.isBlank()) {
            return List.of();
        }

        try {
            return Stream.of(orderFromCustomer.split(","))
                    .map(Integer::parseInt)
                    .map(num -> foods.get(num - 1))
                    .toList();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }
}
