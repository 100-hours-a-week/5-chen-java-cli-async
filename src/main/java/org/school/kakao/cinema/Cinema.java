package org.school.kakao.cinema;

import org.school.kakao.food.Food;
import org.school.kakao.food.FoodFactory;
import org.school.kakao.movie.Genre;
import org.school.kakao.movie.ScreeningMovie;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class Cinema {
    private String name;
    private List<ScreeningMovie> movies;
    private List<Food> foods;

    public Cinema(String name) {
        this.name = name;
        this.movies = List.of(
                new ScreeningMovie("범죄도시4", Genre.ACTION, LocalTime.of(19, 30)),
                new ScreeningMovie("쿵푸팬더4", Genre.ADVENTURE, LocalTime.of(20, 30))
        );
        this.foods = FoodFactory.create();
    }

    public List<ScreeningMovie> getMovieList() {
        return movies;
    }

    public ScreeningMovie choiceMovie(int number) throws IllegalArgumentException {
        try {
            return movies.get(number);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public List<Food> getFoodList() {
        return foods;
    }

    public List<Food> choiceFoods(String order) throws IllegalArgumentException {
        if (order.isBlank()) {
            return List.of();
        }

        try {
            return Stream.of(order.split(","))
                    .map(Integer::parseInt)
                    .map(num -> foods.get(num - 1))
                    .toList();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }
}
