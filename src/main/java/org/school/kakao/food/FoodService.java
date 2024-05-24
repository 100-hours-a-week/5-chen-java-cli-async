package org.school.kakao.food;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;
import java.util.stream.Stream;

public class FoodService {
    private final List<Food> foodsInCinema;

    public FoodService(List<Food> foodsInCinema) {
        this.foodsInCinema = foodsInCinema;
    }

    public List<Food> ask() {
        OutputManager.render();
        for (int i = 1; i <= foodsInCinema.size(); i++) {
            Food food = foodsInCinema.get(i - 1);
            OutputManager.println(i + " : " + food.getName() + " " + food.getPrice());
        }
        return InputManager.nextLine("먹거리 선택하시겠습니까? (쉼표로 구분)", this::choiceFoods);
    }

    private List<Food> choiceFoods(String orderFromCustomer) throws IllegalArgumentException {
        if (orderFromCustomer.isBlank()) {
            return List.of();
        }

        try {
            return Stream.of(orderFromCustomer.split(","))
                    .map(Integer::parseInt)
                    .map(num -> foodsInCinema.get(num - 1))
                    .toList();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
