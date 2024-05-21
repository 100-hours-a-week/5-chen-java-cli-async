package org.school.kakao.movie;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SeatService {
    public void ask() {
        OutputManager.render();
        ScreeningMovie chosenMovie = AppContext.getInstance().getScreeningMovie();

        Map<String, List<Seat>> cinemaSeats = chosenMovie.getSeats();
        for (Map.Entry<String, List<Seat>> entry : cinemaSeats.entrySet()) {
            String key = entry.getKey();
            List<Seat> seats = entry.getValue();
            OutputManager.rawPrintf("%-10s", seats.get(0).getGrade());
            for (int i = 0; i < seats.size(); i++) {
                OutputManager.rawPrintf("%-4s", key + (i + 1));
            }
            OutputManager.rawPrintf("%n");
        }

        String order = InputManager.nextLine("좌석을 선택해 주세요. (쉼표로 구분)");
        List<SeatGrade> seatGrades = choiceSeats(order);
        AppContext.getInstance().setSeatGrades(seatGrades);
    }

    private List<SeatGrade> choiceSeats(String order) {
        if (order.isBlank()) {
            throw new IllegalArgumentException("좌석 선택 없음");
        }

        Map<String, List<Seat>> seats = AppContext.getInstance().getScreeningMovie().getSeats();
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
