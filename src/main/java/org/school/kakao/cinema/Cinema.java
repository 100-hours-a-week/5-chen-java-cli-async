package org.school.kakao.cinema;

import org.school.kakao.food.Food;
import org.school.kakao.food.FoodFactory;
import org.school.kakao.movie.Genre;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.Seat;
import org.school.kakao.movie.SeatGrade;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
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

    public List<Food> getFoods() {
        return foods;
    }

    public List<ScreeningMovie> getMovieList() {
        return movies;
    }

    public ScreeningMovie getMovie(int numFromCustomer) {
        try {
            return movies.get(numFromCustomer - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    public List<Food> choiceFoods(String orderFromCustomer) throws IllegalArgumentException {
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

    public List<SeatGrade> choiceSeats(ScreeningMovie movie, String order) {
        if (order.isBlank()) {
            throw new IllegalArgumentException("좌석 선택 없음");
        }
        Map<String, List<Seat>> seats = movie.getSeats();
        return Stream.of(order.split(","))
                .map(str -> {
                    String[] split = str.split("");
                    String key = split[0];
                    int strNum = Integer.parseInt(split[1]);

                    List<Seat> seatLane = seats.get(key);
                    return seatLane.get(strNum - 1);
                })
                .map(Seat::getGrade)
                .toList();
    }
}
