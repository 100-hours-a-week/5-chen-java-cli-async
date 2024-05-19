package org.school.kakao;

import org.school.kakao.audience.Audience;
import org.school.kakao.audience.Person;
import org.school.kakao.cinema.Cinema;
import org.school.kakao.food.Food;
import org.school.kakao.io.UserInput;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.Seat;
import org.school.kakao.movie.SeatGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scenario {
    private Audience audience;
    private Cinema cinema;

    public Scenario() {

    }

    public void enter() {
        this.audience = askAudience();

        this.cinema = new Cinema("Kakao");

        // 영화 선택
        ScreeningMovie chosenMovie = askMovie();
        audience.setMovie(chosenMovie);

        // 좌석 선택
        List<SeatGrade> seatGrades = askSeats(chosenMovie);
        audience.setSeatGrades(seatGrades);

        // 먹거리 선택
        List<Food> chosenFoods = askFoods();
        audience.setFoods(chosenFoods);


    }

    private List<Food> askFoods() {
        List<Food> foodList = cinema.getFoods();
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
        return chosenFoods;
    }

    private Audience askAudience() {
        int personCount = UserInput.nextInt("몇 명?");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            Integer age = UserInput.nextInt("나이?");
            String gender = UserInput.nextLine("성별? (M/F)");

            people.add(new Person(age, gender));
        }
        return new Audience(people);
    }

    private ScreeningMovie askMovie() {
        List<ScreeningMovie> movieList = cinema.getMovieList();
        System.out.println("상영중인 영화");
        for (int i = 1; i <= movieList.size(); i++) {
            ScreeningMovie movie = movieList.get(i - 1);
            System.out.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        Integer order = UserInput.nextInt("어떤 영화?");
        ScreeningMovie chosenMovie = cinema.getMovie(order);
        System.out.println("선택하신 영화 : " + chosenMovie.getTitle() + " at " + chosenMovie.getTime());
        return chosenMovie;
    }

    private List<SeatGrade> askSeats(ScreeningMovie chosenMovie) {
        Map<String, List<Seat>> cinemaSeats = chosenMovie.getSeats();
        for (Map.Entry<String, List<Seat>> entry : cinemaSeats.entrySet()) {
            String key = entry.getKey();
            List<Seat> seats = entry.getValue();
            System.out.printf("%-10s", seats.get(0).getGrade());
            for (int i = 0; i < seats.size(); i++) {
                System.out.printf("%-4s", key + (i + 1));
            }
            System.out.println();
        }

        String order = UserInput.nextLine("좌석을 선택해 주세요. (쉼표로 구분)");
        // TODO : cinema.validateSeats;
        List<SeatGrade> seatGrades = cinema.choiceSeats(chosenMovie, order);
        return seatGrades;
    }
}
