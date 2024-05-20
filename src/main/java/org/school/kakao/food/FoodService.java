package org.school.kakao.food;

import org.school.kakao.io.InputManager;

import java.util.List;
import java.util.stream.Stream;

public class FoodService {
    private List<Food> foods;

    public FoodService(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> askFoods() {
        for (int i = 1; i <= foods.size(); i++) {
            Food food = foods.get(i - 1);
            System.out.println(i + " : " + food.getName() + " " + food.getPrice());
        }
        List<Food> chosenFoods = choiceFoods(InputManager.nextLine("먹거리 선택하시겠습니까? (쉼표로 구분)"));
        if (chosenFoods.isEmpty()) {
            System.out.println("주문하신 먹거리가 없습니다.");
        } else {
            System.out.println("주문하신 먹거리:");
            for (Food chosenFood : chosenFoods) {
                System.out.println(chosenFood.getName() + " : " + chosenFood.getPrice() + "원");
            }
        }
        return chosenFoods;
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
