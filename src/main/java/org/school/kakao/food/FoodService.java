package org.school.kakao.food;

import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoodService {
    private final List<CinemaFoodQueue> queueList;
    private final List<Food> foodsInCinema;

    public FoodService(List<CinemaFoodQueue> queueList) {
        this.queueList = queueList;
        this.foodsInCinema = queueList.stream().map(CinemaFoodQueue::getFood).toList();
    }

    public List<Food> ask() {
        OutputManager.render();
        for (int i = 1; i <= foodsInCinema.size(); i++) {
            Food food = foodsInCinema.get(i - 1);
            OutputManager.println(i + " : " + food.getName() + " " + food.getPrice());
        }
        List<Food> foods = InputManager.nextLine("먹거리 선택하시겠습니까? (쉼표로 구분)", this::choiceFoods);
        Map<Food, CinemaFoodQueue> queueMap = queueList.stream().collect(Collectors.toMap(CinemaFoodQueue::getFood, q -> q));
        OutputManager.println("음식 가져오는 중....");
        for (Food food : foods) {
            CinemaFoodQueue queue = queueMap.get(food);
            try {
                queue.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return foods;
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
