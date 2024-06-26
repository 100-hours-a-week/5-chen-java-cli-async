package org.school.kakao.movie;

import org.school.kakao.audience.Audience;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;
import java.util.stream.Stream;

public class MovieService {
    private final List<ScreeningMovie> moviesInCinema;

    public MovieService(List<ScreeningMovie> moviesInCinema) {
        this.moviesInCinema = moviesInCinema;
    }

    public MovieDTO ask(Audience audience) {
        OutputManager.render();
        OutputManager.println("현재 상영중인 영화");
        for (int i = 1; i <= moviesInCinema.size(); i++) {
            ScreeningMovie movie = moviesInCinema.get(i - 1);
            OutputManager.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        ScreeningMovie chosenMovie = InputManager.nextInt("영화를 선택해 주세요.", this::choiceMovie);

        OutputManager.render();
        List<List<String>> cinemaSeats = chosenMovie.listing();


        for (List<String> seats : cinemaSeats) {
            for (String seat : seats) {
                OutputManager.rawPrintf("%-4s", seat);
            }
            OutputManager.rawPrintf("%n");
        }

        List<SeatGrade> seatGrades = InputManager.nextLine("좌석을 선택해 주세요. (쉼표로 구분)", order -> {
            if (order.isBlank()) {
                throw new IllegalArgumentException("좌석 선택 없음");
            }

            List<String> seatOrders = Stream.of(order.split(",")).map(String::toUpperCase).toList();

            if (seatOrders.size() != audience.size()) {
                throw new IllegalArgumentException("좌석 개수 맞지 않음");
            }

            for (int i = 0; i < seatOrders.size(); i++) {
                for (int j = 0; j < seatOrders.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (seatOrders.get(i).equals(seatOrders.get(j))) {
                        throw new IllegalArgumentException("같은 좌석을 두 개 예약하셨습니다.");
                    }
                }
            }

            return chosenMovie.book(seatOrders);
        });

        return new MovieDTO(chosenMovie, seatGrades);
    }

    private ScreeningMovie choiceMovie(int num) {
        return moviesInCinema.get(num - 1);
    }
}
