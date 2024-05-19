package org.school.kakao;

import org.school.kakao.audience.Person;
import org.school.kakao.cinema.Cinema;
import org.school.kakao.food.Food;
import org.school.kakao.io.UserInput;
import org.school.kakao.movie.ScreeningMovie;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    public Scenario() {
    }

    public static void enter() {
        // 관객 조사
        int personCount = UserInput.nextInt("몇 명?");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            Integer age = UserInput.nextInt("나이?");
            String gender = UserInput.nextLine("성별? (M/F)");

            people.add(new Person(age, gender));
        }

        Cinema cinema = new Cinema("Kakao");

        // 영화 선택
        List<ScreeningMovie> movieList = cinema.getMovieList();
        System.out.println("상영중인 영화");
        for (int i = 1; i <= movieList.size(); i++) {
            ScreeningMovie movie = movieList.get(i - 1);
            System.out.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        ScreeningMovie movie = cinema.choiceMovie(UserInput.nextInt("어떤 영화?") - 1);

        System.out.println("영화 : " + movie.getTitle());
        System.out.println("시간 : " + movie.getTime());

        // TODO : 좌석 선택

        // 먹거리 선택

        List<Food> foodList = cinema.getFoodList();
        for (int i = 1; i <= foodList.size(); i++) {
            Food food = foodList.get(i - 1);
            System.out.println(i + " : " + food.getName() + " " + food.getPrice());
        }
        List<Food> chosenFoods = cinema.choiceFoods(UserInput.nextLine("먹거리 선택하시겠습니까? (쉼표로 구분)"));
        if (chosenFoods.isEmpty()) {
            System.out.println("주문하신 먹거리가 없습니다.");
        } else {
            System.out.println("주문하신 먹거리:");
            for (Food chosenFood : chosenFoods) {
                System.out.println(chosenFood.getName() + " : " + chosenFood.getPrice() + "원");
            }
        }

    }
}
