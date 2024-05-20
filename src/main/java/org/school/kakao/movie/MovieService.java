package org.school.kakao.movie;

import org.school.kakao.io.InputManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MovieService {
    private List<ScreeningMovie> movies;

    public MovieService(List<ScreeningMovie> movies) {
        this.movies = movies;
    }

    public ScreeningMovie askMovie() {
        System.out.println("상영중인 영화");
        for (int i = 1; i <= movies.size(); i++) {
            ScreeningMovie movie = movies.get(i - 1);
            System.out.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        Integer order = InputManager.nextInt("어떤 영화?");
        ScreeningMovie chosenMovie = movies.get(order - 1);
        System.out.println("선택하신 영화 : " + chosenMovie.getTitle() + " at " + chosenMovie.getTime());

        return chosenMovie;
    }

    public List<SeatGrade> askSeats(ScreeningMovie chosenMovie) {
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

        String order = InputManager.nextLine("좌석을 선택해 주세요. (쉼표로 구분)");
        // TODO : cinema.validateSeats;
        return choiceSeats(chosenMovie, order);
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
