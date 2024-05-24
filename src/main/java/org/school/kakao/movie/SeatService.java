package org.school.kakao.movie;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;

public class SeatService {
    public void ask() {
        OutputManager.render();
        ScreeningMovie chosenMovie = AppContext.getInstance().getScreeningMovie();

        List<List<String>> cinemaSeats = chosenMovie.listing();

        for (List<String> seats : cinemaSeats) {
            for (String seat : seats) {
                OutputManager.rawPrintf("%-4s", seat);
            }
            OutputManager.rawPrintf("%n");
        }

        List<SeatGrade> seatGrades = InputManager.nextLine("좌석을 선택해 주세요. (쉼표로 구분)", this::choiceSeats);
        AppContext.getInstance().setSeatGrades(seatGrades);
    }

    private List<SeatGrade> choiceSeats(String order) {
        if (order.isBlank()) {
            throw new IllegalArgumentException("좌석 선택 없음");
        }

        ScreeningMovie movie = AppContext.getInstance().getScreeningMovie();

        return movie.book(List.of(order.split(",")));
    }
}
