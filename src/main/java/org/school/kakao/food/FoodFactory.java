package org.school.kakao.food;

import java.util.List;

public class FoodFactory {
    private FoodFactory() {
    }

    public static List<Food> create() {
        return List.of(
                new Food("팝콘", 1000),
                new Food("핫도그", 2000),
                new Food("아이스크림", 3000),
                new Food("콜라", 4000)
        );
    }
}
